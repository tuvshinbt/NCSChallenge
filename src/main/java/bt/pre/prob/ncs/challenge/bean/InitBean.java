/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.pre.prob.ncs.challenge.bean;

import bt.pre.prob.ncs.challenge.logger.MyLogger;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author tuvshuu
 */
@Component
public class InitBean implements ApplicationRunner {

    @MyLogger
    private static Logger logger;

    @Value("${name}")
    private String author;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("<<< Author - " + author + " >>>");
    }

}
