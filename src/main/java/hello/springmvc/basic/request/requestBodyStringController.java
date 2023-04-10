package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class requestBodyStringController {
    @PostMapping("/request-body-string-v1")
    public void requestBodyStirng(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody:{}",messageBody);
        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStirngV2(InputStream inputStream, Writer responseWriter) throws IOException {
        //ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody:{}",messageBody);
        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStirngV3(HttpEntity<String> httpEntity)  {

        String messageBody = httpEntity.getBody();

        log.info("messageBody:{}",messageBody);
        return new HttpEntity<>("ok");
    }

    @PostMapping("/request-body-string-entity")
    public HttpEntity<String> requestBodyStirngEntity(RequestEntity<String> httpEntity)  {

        String messageBody = httpEntity.getBody();

        log.info("messageBody:{}",messageBody);
        return new ResponseEntity<String>("ok",HttpStatus.CREATED);
    }
    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStirngV4(@RequestBody String messageBody)  {

        log.info("messageBody:{}",messageBody);
        return "ok";
    }

}
