package com.qzl.kotlin_springboot

import com.qzl.kotlin_springboot.bean.TestBean
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["测试接口"])
@RestController
class TestController {

    @Autowired
    var testBean:TestBean? = null

    @Value("\${hh.age}")
    val age: String = ""

    @ApiOperation(value = "获取姓名和年龄")
    @GetMapping("/hello")
    fun getString():String{
        return "姓名：${testBean?.names}=====年龄：${age}"
    }
}