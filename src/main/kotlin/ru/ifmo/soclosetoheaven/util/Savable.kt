package ru.ifmo.soclosetoheaven.util

interface Savable<T> {
    fun save(arg: T)
    fun clear(arg: T)
}