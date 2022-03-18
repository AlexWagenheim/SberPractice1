//package com.js.generics.homework.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Сделайте методы типизированными (Используйте generics)
 */
public class UtilClass {
    /**
     * Возвращает true, если список равен null или если список пуст
     *
     * @param list список.
     * @return true, если список равен null или если список пуст
     */
    public static <E> boolean isBlank(List<E> list) {

        return list == null || list.size() == 0;
    }

    /**
     * Получает последний элемент в коллекции
     * Если список равен null, то выбрасывается исключение IllegalArgumentException
     *
     * @param list список
     * @return последний элемент в коллекции
     */
    public static <E> E getLastElem(List<E> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        } else {
            return list.get(list.size() - 1);
        }
    }

    /**
     * Получает элемент из списка.
     * Если в аргументах список или элемент равен null, то выбрасывается исключение IllegalArgumentException
     * Если элемент не найден, то возвращаем null
     *
     * @param list список, в котором ищем элемент
     * @param elem элемент, который ищется в списке.
     * @return элемент из списка.
     */
    public static <E> E findElem(List<E> list, E elem) {
        if (list == null || elem == null) {
            throw new IllegalArgumentException();
        } else {
            if (list.contains(elem)) {
                return list.get(list.indexOf(elem));
            } else {
                return null;
            }
        }
    }

    /**
     * Объединяет два списка.
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return возвращает объединенный список.
     */
    public static <E> List<E> union(List<E> list1, List<E> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException();
        } else {
            List<E> unionLists = new ArrayList<>(list1);
            unionLists.addAll(list2);
            return unionLists;
        }
    }

    /**
     * Удаляет все элементы из списка list1, которые встречаются в списке list2
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return возвращает список, который содержит элементы из списка list1, в котором удалены все элементы из
     * списка list2.
     */
    public static <E> List<E> removeAll(List<E> list1, List<E> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException();
        } else {
            List<E> difLists = new ArrayList<>(list1);
            for (E elem : list2) {
                if (difLists.contains(elem)) {
                    difLists.remove(elem);
                }
            }
            return difLists;
        }
    }

    /**
     * Складывает числа из обоих списков и возвращает сумму.
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     * Подсказка:
     * 1) Помните, что все объекты чисел (Integer, Double, Float и т.д) наследуются от общего предка Number.
     * 2) Используйте ограничения для типизации, чтобы списки могли содержать любые числа (Integer, Double, Float и т.д)
     * 3) Для приведения Number к double воспользуйтесь num.doubleValue();
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return сумма чисел.
     */
    public static <N extends Number> double sum(List<? extends Number> list1, List<? extends Number> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException();
        } else {
            double sum = 0;

            for (Number num: list1) {
                sum += num.doubleValue();
            }
            for (Number num: list2) {
                sum += num.doubleValue();
            }
            return sum;
        }
    }
}
