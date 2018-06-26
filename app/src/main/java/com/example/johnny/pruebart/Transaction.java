package com.example.johnny.pruebart;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Transaction {
    String id;
    String total;
    List <Producto> productoList= new List<Producto>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Producto> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(Producto producto) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Producto> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull Collection<? extends Producto> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Producto get(int i) {
            return null;
        }

        @Override
        public Producto set(int i, Producto producto) {
            return null;
        }

        @Override
        public void add(int i, Producto producto) {

        }

        @Override
        public Producto remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<Producto> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Producto> listIterator(int i) {
            return null;
        }

        @NonNull
        @Override
        public List<Producto> subList(int i, int i1) {
            return null;
        }
    };


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(Producto producto) {
        this.productoList.add(producto);
    }

}
