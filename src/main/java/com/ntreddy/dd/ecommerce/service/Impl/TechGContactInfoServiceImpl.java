package com.ntreddy.dd.ecommerce.service.Impl;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.EMAIL_IN_USE;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntreddy.dd.ecommerce.domain.TechGContactInfo;
import com.ntreddy.dd.ecommerce.exception.EmailException;
import com.ntreddy.dd.ecommerce.repository.TechGContactInfoRepository;
import com.ntreddy.dd.ecommerce.service.TechGContactInfoService;
import com.ntreddy.dd.ecommerce.service.email.MailSender;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechGContactInfoServiceImpl implements TechGContactInfoService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private TechGContactInfoRepository techGRepository;


   

    @Override
    @Transactional
    public String registerUser(TechGContactInfo user) {
    	if (techGRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailException(EMAIL_IN_USE);
        }
    	techGRepository.save(user);
    	mailSender.sendEmail(user);
        return "SUCCESS";
    }

}
