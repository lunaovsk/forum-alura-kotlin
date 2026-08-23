package br.com.lunaovsk.forum.mapper.request

interface RequestMapper<T, U> {
    fun map(model: T): U;
}