package com.floriantrecul.leboncointestjunior.data.mapper

interface Mapper<E, D> {

    /**
     * This function map entity to the any type
     * @param E is entity parameter
     * @return D is the any type result
     */
    fun mapFromEntity(type: E): D

    /**
     * This function map any object to the entity
     * @param D is any type parameter
     * @return E is the entity result
     */
    fun mapToEntity(type: D): E

}