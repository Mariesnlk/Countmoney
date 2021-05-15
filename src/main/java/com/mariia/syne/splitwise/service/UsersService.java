package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.model.Transactions;
import com.mariia.syne.splitwise.model.Users;
import com.mariia.syne.splitwise.repository.IncomeRepository;
import com.mariia.syne.splitwise.repository.TransactionsRepository;
import com.mariia.syne.splitwise.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private IncomeRepository incomesRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    static final long MILS_IN_DAY=86400000L;


    public List<Users> getAllUsers() {

        List<Users> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public List<Users> getListUsersByGroup(Integer id_group) {

        List<Users> users = usersRepository.getListUsersByGroup(id_group);

        for (Users u : users) {
            u.setSumTransactions(getSumUserTransactions(u));
            u.setSumIncomes(incomesRepository.getSumAllIncomes(u.getId_users()));
        }

        return users;
    }

    public Double getSumUserTransactions(Users user) {


        Double sumIrregular = usersRepository.getSumUserTransactions(user.getId_users());
        List<Transactions> regTransactions = transactionsRepository.getAllByIdUser(user);

        if (sumIrregular == null) {
            sumIrregular = 0.0;
        }

        double regular = 0;
        if (regTransactions != null) {
            regTransactions = regTransactions.stream().
                    filter(t -> t.getId_type_transaction().getId_type_transaction() == 2).collect(Collectors.toList());

            double identity = 0;

            regular = regTransactions.stream().reduce(identity, (sum, y) -> sum + getSumByRegular(y), Double::sum);
        }
        return sumIrregular + regular;
    }

    public static double getSumByRegular(Transactions t) {
        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();
        Calendar calNow = Calendar.getInstance();
        calFrom.setTime(t.getPeriod_from());
        calTo.setTime(t.getPeriod_to());
        calNow.setTime(new Date());
        Calendar calEnd =null;
        if(calTo.before( calNow)){
            calEnd=calTo;
        }
        else{
            calEnd=calNow;
        }
        int period =0;

        if(t.getId_frequency().getValue().equals("month")) {
            int diffYear = calEnd.get(Calendar.YEAR) - calFrom.get(Calendar.YEAR);
            period =  diffYear*12+calEnd.get(Calendar.MONTH) - calFrom.get(Calendar.MONTH);
        }
        else  if(t.getId_frequency().getValue().equals("week")) {

            period =(int) ((calEnd.getTimeInMillis() - calFrom.getTimeInMillis())/(MILS_IN_DAY*7));

        }
        else  if(t.getId_frequency().getValue().equals("day")) {

            period =(int) ((calEnd.getTimeInMillis() - calFrom.getTimeInMillis())/MILS_IN_DAY);

        }

        return t.getSum() * period;

    }



    public Users getUser(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Integer addUser(Users user) {

        return usersRepository.save(user).getId_users();
    }

    public void updateUser(Users user, Integer id) {

        usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.getUserByLogin(username);
    }
}
