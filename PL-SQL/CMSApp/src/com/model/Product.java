package com.model;

import java.time.LocalDate;

    public class Product implements Comparable<Product>{
        private int id;
        private String name;
        private double price;
        private LocalDate dateOfPublish;

        public Product() {
        }

        public Product(int id, String name, double price, LocalDate dateOfPublish) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.dateOfPublish = dateOfPublish;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public LocalDate getDateOfPublish() {
            return dateOfPublish;
        }

        public void setDateOfPublish(LocalDate dateOfPublish) {
            this.dateOfPublish = dateOfPublish;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", dateOfPublish=" + dateOfPublish +
                    '}';
        }

        @Override
        public int compareTo(Product p2) {
            return this.id - p2.id;
        }


//    @Override
//    public int compareTo(Product p2) { // this method will hold my default sort comparison criteria
//        // the criteria for default sort is : id
//        // p1 will be available using 'this'
//
//        /*
//          this.compareTo(p2)   ---- p1.compareTo(p2)
//        * */
//        int id1 = this.id;
//        int id2 = p2.id;
//        if(id1 < id2) return -1;
//        if(id1 > id2) return 1;
//        return 0;
//    }


    }
/*
  [5,2] [id1,id2]
  if(id1 < id2) [2,5] : this is already in ASC order   [-ve]
  if(id1 > id2) [5,2]: we need to swap [2,5]  --- here, we need to swap [+ve]
  if(id1 == id2) [2,2] : already in ASC order -- 0

  return +ve  - i will do the swap
  return -ve - i will consider no swap for ASC
  return 0 - i will do nothing, both no are same
* */