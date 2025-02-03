package com.bankapp.service.aspects;

import com.bankapp.exceptions.AccountNotFoundException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AccountNotFoundAspect {

    private static final Logger logger = LoggerFactory.getLogger(AccountNotFoundAspect.class);

    @AfterThrowing(value = "execution(* com.bankapp.service.AccountServiceImp.*(..))", throwing = "ex")
    public void accountNotFound(AccountNotFoundException ex) {
        System.out.println("________________________");
        logger.error(ex.getMessage());
        System.out.println("________________________");
    }
}
