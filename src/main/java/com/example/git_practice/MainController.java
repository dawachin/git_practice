package com.example.git_practice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

/**
 * 
 * 試験的エンドポイント追加
 */

@DeleteMapping("test")
public TestBean test(@RequestBody TestBean testBean) {
    return testBean;
}

private static Logger logger = LoggerFactory.getLogger(MainController.class);

@RequestMapping(value = "get", method = RequestMethod.GET)
public int logSample() {
    logger.info("IPアドレス出力");
    return 1;
}
@RequestMapping(value = "log_error", method = RequestMethod.GET)
public int logError() {
    logger.error("Errorです");
    return 2;
}



}
