package com.compassuol.sp.challenge.msorders.common;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductConstants {

    public static final ProductDTO PRODUCTDTO = new ProductDTO(4L,"name", 99.0, "description with more 10 caracters");

    public static final Product PRODUCT = new Product(4L,"name", 99.0, "description with more 10 caracters");
    public static final ProductDTO INVALID_PRODUCT = new ProductDTO(-1L,"", -1.0, "");

    public static final Product TheLastofUs = new Product(1L, "The Last of Us", 120.0, "Adventure and mysterious wait for you");
    public static final Product GodOfWar = new Product(2L, "God of War", 140.0, "The greatest experience in a game for people that love wars");
    public static final Product GTAV = new Product(3L, "GTA V", 39.0, "Go there and explode every thing");
    public static final List<Product> PLANETS = new ArrayList<>() {
        {
            add(TheLastofUs);
            add(GodOfWar);
            add(GTAV);
        }
    };
}