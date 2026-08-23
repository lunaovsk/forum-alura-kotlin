package br.com.lunaovsk.forum.validation

interface Validator<T> {
    fun validate(model: T)
}