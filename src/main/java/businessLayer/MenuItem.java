package businessLayer;

import java.util.*;

public abstract class MenuItem {
    BaseProduct baseProduct;
    List<MenuItem> menuItems = new List<MenuItem>() {
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

        @Override
        public Iterator<MenuItem> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(MenuItem menuItem) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends MenuItem> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends MenuItem> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public MenuItem get(int index) {
            return null;
        }

        @Override
        public MenuItem set(int index, MenuItem element) {
            return null;
        }

        @Override
        public void add(int index, MenuItem element) {

        }

        @Override
        public MenuItem remove(int index) {
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

        @Override
        public ListIterator<MenuItem> listIterator() {
            return null;
        }

        @Override
        public ListIterator<MenuItem> listIterator(int index) {
            return null;
        }

        @Override
        public List<MenuItem> subList(int fromIndex, int toIndex) {
            return null;
        }
    } ;
   CompositeProduct compositeProduct;

    public abstract int computePrice();
    public abstract void increment();
    public abstract String getTitle();
    public abstract int getOrdersNo();
}
