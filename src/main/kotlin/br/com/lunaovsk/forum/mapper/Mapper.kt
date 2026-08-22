package br.com.lunaovsk.forum.mapper

interface Mapper<T, U> {
    fun map(model: T): U;
}