package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.entity.Transactions;
import com.mariia.syne.splitwise.entity.Users;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<Users> getAllUsers() {

        List<Users> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public List<Users> getListUsersByGroup(Integer id_group) {

        List<Users> users = usersRepository.getListUsersByGroup(id_group);//new ArrayList<>();
        // usersRepository.getListUsersByGroup(id_group).forEach(users::add);

        for (Users u : users) {
            u.setSumTransactions(getSumUserTransactions(u));

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

    public double getSumByRegular(Transactions t) {
        Calendar cal = Calendar.getInstance();
        Calendar calNow = Calendar.getInstance();
        cal.setTime(t.getPeriod_from());
        calNow.setTime(new Date());
        int month = calNow.get(Calendar.MONTH) - cal.get(Calendar.MONTH);
        return t.getSum() * month;

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
