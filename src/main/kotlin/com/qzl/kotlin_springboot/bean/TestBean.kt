package com.qzl.kotlin_springboot.bean

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TestBean {
    @Value("\${qzl.name}")
    val names: String? = null
}