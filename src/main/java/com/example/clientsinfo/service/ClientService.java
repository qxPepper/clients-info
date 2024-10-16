package com.example.clientsinfo.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {
    public String defineType(String contact) {
        // email
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contact);
        if (matcher.matches()) {
            return "email";
        }

        // phone
        regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(contact);
        if (matcher.matches()) {
            return "phone";
        }

        return "not defined";
    }
}
