package com.example.mybatisplus;

import com.example.mybatisplus.config.EcmProductExtend;
import com.example.mybatisplus.config.EcmProductExtendMapper;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTests {

  @Autowired
  private EcmProductExtendMapper ecmProductExtendMapper;

  @Test
  void contextLoads() {
    List<EcmProductExtend> arrayList = Lists.newArrayList(new EcmProductExtend());

    ecmProductExtendMapper.insertBatchSomeColumn(arrayList);
  }

}
