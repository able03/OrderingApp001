package com.example.orderingapp;

import com.example.orderingapp.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class LoadItems
{

    private List<ProductModel> electronics;
    private List<ProductModel> fashion;
    private List<ProductModel> food;
    private List<ProductModel> all;

    public List<ProductModel> getAll()
    {
        all = new ArrayList<>();



        //ELECTRONICS
        all.add(new ProductModel(1, "SmartPhone (Samsung Galaxy S21)",
                "The Samsung Galaxy S21 features a stunning 6.2-inch AMOLED display, a powerful Exynos 2100 processor, triple rear cameras, and 5G capability.",
                45000,0, R.drawable.elec_samsung));

        all.add(new ProductModel(2, "Wireless Headphones (Sony WH-1000XM4)",
                "Sony WH-1000XM4 offers industry-leading noise cancellation, exceptional sound quality, long battery life, touch controls, and comfortable design.",
                16000, 0, R.drawable.elec_sony));

        all.add(new ProductModel(3, "Smartwatch (Apple Watch Series 6)",
                "Apple Watch Series 6 boasts advanced health tracking features, a bright Always-On Retina display, ECG app, GPS, and cellular connectivity.",
                25000, 0, R.drawable.elec_smarthwatch));


        all.add(new ProductModel(4, " Laptop (Dell XPS 13)",
                "Dell XPS 13 is a sleek and powerful ultrabook with a stunning InfinityEdge display, fast performance, long battery life, and premium build quality.",
                60000, 0, R.drawable.elec_laptop));

        all.add(new ProductModel(5, "Wireless Speaker (JBL Charge 4)",
                "JBL Charge 4 is a portable Bluetooth speaker with powerful sound, IPX7 waterproof rating, built-in power bank, and 20 hours of battery life.",
                7500, 0, R.drawable.elec_speaker));


        //FASHION
        all.add(new ProductModel(6, "Men's Watch (Seiko 5 Sports Automatic)",
                "Seiko 5 Sports Automatic watch features a stainless steel case, automatic movement, day-date display, and a classic stainless steel bracelet.",
                10000,0, R.drawable.fash_watch));

        all.add(new ProductModel(7, "Women's Handbag (Louis Vuitton Speedy 30)",
                "Louis Vuitton Speedy 30 is an iconic handbag crafted from Monogram canvas, featuring rolled leather handles, spacious interior, and signature LV monogram.",
                80000,0, R.drawable.fash_bag));

        all.add(new ProductModel(8, "Sneakers (Nike Air Force 1)",
                "Nike Air Force 1 is a classic basketball-inspired sneaker with a timeless design, durable leather upper, cushioned midsole, and iconic Air-Sole unit.",
                5500,0, R.drawable.fash_nike));

        all.add(new ProductModel(9, "Designer Sunglasses (Ray-Ban Wayfarer Classic)",
                " Ray-Ban Wayfarer Classic sunglasses feature a timeless design, durable acetate frame, polarized lenses, and iconic Ray-Ban logo on the temples.",
                8000,0, R.drawable.fash_sunglass));

        all.add(new ProductModel(10, "Women's Dress (Zara Wrap Dress)",
                "Zara Wrap Dress is a stylish and versatile piece featuring a flattering wrap silhouette, V-neckline, tie waist, and flowy fabric perfect for any occasion.",
                2500,0, R.drawable.fash_dress));



        //FOOD
        all.add(new ProductModel(11, "Pizza (Pepperoni Pizza from Shakey's)",
                "Shakey's Pepperoni Pizza is a classic favorite with a crispy crust, savory tomato sauce, generous pepperoni slices, and melted mozzarella cheese.",
                400,0, R.drawable.food_pizza));

        all.add(new ProductModel(12, "Sushi (Assorted Sushi Platter from Sushi Nori)",
                "Sushi Nori's Assorted Sushi Platter includes a variety of fresh nigiri and maki sushi, featuring tuna, salmon, California rolls, and more.",
                900,0, R.drawable.food_sushi));

        all.add(new ProductModel(13, "Burger (Double Cheeseburger from McDonald's)",
                "McDonald's Double Cheeseburger is a delicious combination of two juicy beef patties, melted cheese slices, pickles, onions, ketchup, and mustard, all sandwiched in a soft bun.",
                150,0, R.drawable.food_burger));

        all.add(new ProductModel(14, "Coffee (Starbucks Caramel Macchiato)",
                "Starbucks Caramel Macchiato is a delicious espresso-based beverage with velvety steamed milk, rich espresso, and a sweet caramel drizzle.",
                180,0, R.drawable.food_coffee_tall));






        return all;
    }

    public List<ProductModel> getElectronicsList()
    {
        electronics = new ArrayList<>();

        electronics.add(new ProductModel(1, "SmartPhone (Samsung Galaxy S21)",
                "The Samsung Galaxy S21 features a stunning 6.2-inch AMOLED display, a powerful Exynos 2100 processor, triple rear cameras, and 5G capability.",
                45000,0, R.drawable.elec_samsung));

        electronics.add(new ProductModel(2, "Wireless Headphones (Sony WH-1000XM4)",
                "Sony WH-1000XM4 offers industry-leading noise cancellation, exceptional sound quality, long battery life, touch controls, and comfortable design.",
                16000, 0, R.drawable.elec_sony));

        electronics.add(new ProductModel(3, "Smartwatch (Apple Watch Series 6)",
                "Apple Watch Series 6 boasts advanced health tracking features, a bright Always-On Retina display, ECG app, GPS, and cellular connectivity.",
                25000, 0, R.drawable.elec_smarthwatch));


        electronics.add(new ProductModel(4, " Laptop (Dell XPS 13)",
                "Dell XPS 13 is a sleek and powerful ultrabook with a stunning InfinityEdge display, fast performance, long battery life, and premium build quality.",
                60000, 0, R.drawable.elec_laptop));

        electronics.add(new ProductModel(5, "Wireless Speaker (JBL Charge 4)",
                "JBL Charge 4 is a portable Bluetooth speaker with powerful sound, IPX7 waterproof rating, built-in power bank, and 20 hours of battery life.",
                7500, 0, R.drawable.elec_speaker));

        return electronics;
    }

    public List<ProductModel> getFashionList()
    {
        fashion = new ArrayList<>();

        fashion.add(new ProductModel(6, "Men's Watch (Seiko 5 Sports Automatic)",
                "Seiko 5 Sports Automatic watch features a stainless steel case, automatic movement, day-date display, and a classic stainless steel bracelet.",
                10000,0, R.drawable.fash_watch));

        fashion.add(new ProductModel(7, "Women's Handbag (Louis Vuitton Speedy 30)",
                "Louis Vuitton Speedy 30 is an iconic handbag crafted from Monogram canvas, featuring rolled leather handles, spacious interior, and signature LV monogram.",
                80000,0, R.drawable.fash_bag));

        fashion.add(new ProductModel(8, "Sneakers (Nike Air Force 1)",
                "Nike Air Force 1 is a classic basketball-inspired sneaker with a timeless design, durable leather upper, cushioned midsole, and iconic Air-Sole unit.",
                5500,0, R.drawable.fash_nike));

        fashion.add(new ProductModel(9, "Designer Sunglasses (Ray-Ban Wayfarer Classic)",
                " Ray-Ban Wayfarer Classic sunglasses feature a timeless design, durable acetate frame, polarized lenses, and iconic Ray-Ban logo on the temples.",
                8000,0, R.drawable.fash_sunglass));

        fashion.add(new ProductModel(10, "Women's Dress (Zara Wrap Dress)",
                "Zara Wrap Dress is a stylish and versatile piece featuring a flattering wrap silhouette, V-neckline, tie waist, and flowy fabric perfect for any occasion.",
                2500,0, R.drawable.fash_dress));


        return fashion;
    }

    public List<ProductModel> getFoodList()
    {
        food = new ArrayList<>();

        food.add(new ProductModel(11, "Pizza (Pepperoni Pizza from Shakey's)",
                "Shakey's Pepperoni Pizza is a classic favorite with a crispy crust, savory tomato sauce, generous pepperoni slices, and melted mozzarella cheese.",
                400,0, R.drawable.food_pizza));

        food.add(new ProductModel(12, "Sushi (Assorted Sushi Platter from Sushi Nori)",
                "Sushi Nori's Assorted Sushi Platter includes a variety of fresh nigiri and maki sushi, featuring tuna, salmon, California rolls, and more.",
                900,0, R.drawable.food_sushi));

        food.add(new ProductModel(13, "Burger (Double Cheeseburger from McDonald's)",
                "McDonald's Double Cheeseburger is a delicious combination of two juicy beef patties, melted cheese slices, pickles, onions, ketchup, and mustard, all sandwiched in a soft bun.",
                150,0, R.drawable.food_burger));

        food.add(new ProductModel(14, "Coffee (Starbucks Caramel Macchiato)",
                "Starbucks Caramel Macchiato is a delicious espresso-based beverage with velvety steamed milk, rich espresso, and a sweet caramel drizzle.",
                180,0, R.drawable.food_coffee_tall));



        return food;
    }

}
