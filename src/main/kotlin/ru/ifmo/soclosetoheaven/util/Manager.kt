package ru.ifmo.soclosetoheaven.util

interface Manager<ArgType, ReturnType> {

    fun manage(arg: ArgType) : ReturnType
}