package com.sda.ramona.bookManagement.repository;

import com.sda.ramona.bookManagement.model.Review;

   public class ReviewRepositoryImpl extends BaseRepositoryImpl<Review, Integer> implements ReviewRepository {

        public ReviewRepositoryImpl() {
            super(Review.class);
        }
   }


