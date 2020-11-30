package com.abc.lombok.log;

import lombok.extern.java.Log;

@Log
public class LogLombok {

  public void log() {
    log.info("打个日志");
  }
}
