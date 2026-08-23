package br.com.lunaovsk.forum.mapper.view

interface Mapper<T, U> {
    fun map(model: T): U;
}