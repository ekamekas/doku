package id.masekas.doku.example.repository

import id.masekas.doku.example.model.Product
import java.math.BigDecimal

class ProductDefaultRepository: Repository.Product {

    override fun getProductByOrder(orderId: String): List<Product> {
        return listOf(
            Product(
                name = "OCS",
                description = "Organic Chia Seed",
                price = BigDecimal(43000)
            ),
            Product(
                name = "ASP",
                description = "Abon Sapi Pilihan",
                price = BigDecimal(87300)
            ),
            Product(
                name = "BCS",
                description = "Black Chia Seed",
                price = BigDecimal(67000)
            ),
            Product(
                name = "BG",
                description = "Bawang Goreng",
                price = BigDecimal(32000)
            ),
            Product(
                name = "CA",
                description = "Cakalang Asap",
                price = BigDecimal(120250)
            ),
            Product(
                name = "NWA",
                description = "Natural Whole Almond",
                price = BigDecimal(12500)
            ),
            Product(
                name = "KK",
                description = "Kentang Kering",
                price = BigDecimal(42000)
            ),
            Product(
                name = "IWC",
                description = "Ikan Wader Crispy",
                price = BigDecimal(32000)
            ),
            Product(
                name = "ACC",
                description = "Almong Crispy Cheese",
                price = BigDecimal(62000)
            ),
            Product(
                name = "Cheese - Cheddar, Mild",
                description = "Yucca",
                price = BigDecimal(34609.31)
            ),
            Product(
                name = "Lemonade - Mandarin, BigDecimal(91 Ml",
                description = "Bread - Olive Dinner Roll",
                price = BigDecimal(11471.41)
            ),
            Product(
                name = "Fish - Base, Bouillion",
                description = "Lamb - Whole Head Off",
                price = BigDecimal(18329.11)
            ),
            Product(
                name = "Oil - Grapeseed Oil",
                description = "Skewers - Bamboo",
                price = BigDecimal(20420.51)
            ),
            Product(
                name = "Coriander - Ground",
                description = "Oven Mitt - BigDecimal(3 Inch",
                price = BigDecimal(20578.41)
            ),
            Product(
                name = "Wild Boar - Tenderloin",
                description = "Kahlua",
                price = BigDecimal(24850.11)
            ),
            Product(
                name = "Chocolate - Liqueur Cups With Foil",
                description = "Jam - Blackberry, BigDecimal(0 Ml Jar",
                price = BigDecimal(1125.51)
            ),
            Product(
                name = "Steam Pan Full Lid",
                description = "White Baguette",
                price = BigDecimal(5892.81)
            ),
            Product(
                name = "Beef - Flank Steak",
                description = "Capers - Ox Eye Daisy",
                price = BigDecimal(6429.01)
            ),
            Product(
                name = "Beef - Striploin Aa",
                description = "Mustard Prepared",
                price = BigDecimal(04281.61)
            ),
            Product(
                name = "Dragon Fruit",
                description = "Soup - Campbells Chicken",
                price = BigDecimal(7016.71)
            ),
            Product(
                name = "Onions - Red",
                description = "Gatorade - Fruit Punch",
                price = BigDecimal(8395.41)
            ),
            Product(
                name = "Breakfast Quesadillas",
                description = "Yoplait Drink",
                price = BigDecimal(39848.91)
            ),
            Product(
                name = "Turkey Tenderloin Frozen",
                description = "Pepsi, BigDecimal(55 Ml",
                price = BigDecimal(5834.71)
            ),
            Product(
                name = "Salt - Seasoned",
                description = "Beer - True North Strong Ale",
                price = BigDecimal(7894.01)
            ),
            Product(
                name = "Breadfruit",
                description = "Sprouts - Corn",
                price = BigDecimal(9414.21)
            ),
            Product(
                name = "Potatoes - Instant, Mashed",
                description = "Fish - Bones",
                price = BigDecimal(3532.31)
            ),
            Product(
                name = "Chicken Thigh - Bone Out",
                description = "Wine - Chianti Classica Docg",
                price = BigDecimal(0184.71)
            ),
            Product(
                name = "Chilli Paste, Ginger Garlic",
                description = "Salmon - Atlantic, No Skin",
                price = BigDecimal(02296.31)
            ),
            Product(
                name = "Veal - Sweetbread",
                description = "Cheese - Cream Cheese",
                price = BigDecimal(2277.71)
            ),
            Product(
                name = "Wine - Zonnebloem Pinotage",
                description = "Chips Potato Swt Chilli Sour",
                price = BigDecimal(5165.41)
            ),
            Product(
                name = "Chocolate - Liqueur Cups With Foil",
                description = "Chicken - Diced, Cooked",
                price = BigDecimal(6631.61)
            ),
            Product(
                name = "Wine - Pinot Grigio Collavini",
                description = "Beer - Mcauslan Apricot",
                price = BigDecimal(6494.31)
            ),
            Product(
                name = "Sauce - Soya, Light",
                description = "Beer - Labatt Blue",
                price = BigDecimal(38494.71)
            ),
            Product(
                name = "Chicken - Ground",
                description = "Soup - Campbells Beef Noodle",
                price = BigDecimal(32488.71)
            ),
            Product(
                name = "Steam Pan - Half Size Deep",
                description = "Mahi Mahi",
                price = BigDecimal(1038.11)
            ),
            Product(
                name = "Icecream - Dstk Super Cone",
                description = "Marjoram - Fresh",
                price = BigDecimal(45049.21)
            ),
            Product(
                name = "Energy - Boo - Koo",
                description = "Lamb - Leg, Bone In",
                price = BigDecimal(1906.31)
            ),
            Product(
                name = "Ecolab - Balanced Fusion",
                description = "Red Pepper Paste",
                price = BigDecimal(3759.31)
            ),
            Product(
                name = "Beef - Top Butt Aaa",
                description = "Lid - BigDecimal(oz Med Rec",
                price = BigDecimal(02957.01)
            ),
            Product(
                name = "Aspic - Light",
                description = "Squeeze Bottle",
                price = BigDecimal(8713.41)
            ),
            Product(
                name = "Stainless Steel Cleaner Vision",
                description = "Muffin - Carrot Individual Wrap",
                price = BigDecimal(1703.81)
            ),
            Product(
                name = "Flour Dark Rye",
                description = "Cup - BigDecimal(oz Coffee Perforated",
                price = BigDecimal(41829.81)
            ),
            Product(
                name = "Wine - Cava Aria Estate Brut",
                description = "Fish - Base, Bouillion",
                price = BigDecimal(02506.81)
            ),
            Product(
                name = "Strawberries - California",
                description = "Milk BigDecimal(% BigDecimal(00 Ml",
                price = BigDecimal(9604.01)
            ),
            Product(
                name = "Soup - Campbells Chicken",
                description = "Tabasco Sauce, BigDecimal( Oz",
                price = BigDecimal(46663.41)
            ),
            Product(
                name = "Flower - Commercial Bronze",
                description = "Tomatoes - Heirloom",
                price = BigDecimal(7199.71)
            ),
            Product(
                name = "Venison - Racks Frenched",
                description = "Curry Powder",
                price = BigDecimal(09023.51)
            ),
            Product(
                name = "Steam Pan - Half Size Deep",
                description = "Brownies - Two Bite, Chocolate",
                price = BigDecimal(5420.01)
            ),
            Product(
                name = "Wine - Red Oakridge Merlot",
                description = "Onions - Red",
                price = BigDecimal(2730.91)
            ),
            Product(
                name = "Pasta - Lasagne, Fresh",
                description = "Rice - BigDecimal( Grain Blend",
                price = BigDecimal(45124.51)
            ),
            Product(
                name = "Pastry - Raisin Muffin - Mini",
                description = "Guinea Fowl",
                price = BigDecimal(6156.41)
            ),
            Product(
                name = "Cauliflower",
                description = "Bay Leaf Fresh",
                price = BigDecimal(18452.61)
            ),
            Product(
                name = "The Pop Shoppe - Cream Soda",
                description = "Clams - Littleneck, Whole",
                price = BigDecimal(4701.61)
            ),
            Product(
                name = "Nantucket - Orange Mango Cktl",
                description = "Langers - Mango Nectar",
                price = BigDecimal(8869.91)
            ),
            Product(
                name = "Soup - Campbells Asian Noodle",
                description = "Cherries - Maraschino,jar",
                price = BigDecimal(2666.11)
            ),
            Product(
                name = "Wine - Cahors Ac BigDecimal(000, Clos",
                description = "Chocolate Liqueur - Godet White",
                price = BigDecimal(09577.61)
            ),
            Product(
                name = "Cheese - Cambozola",
                description = "Beef - Ground Medium",
                price = BigDecimal(36112.61)
            ),
            Product(
                name = "Port - BigDecimal(4 Brights",
                description = "Lemonade - Black Cherry, BigDecimal(91 Ml",
                price = BigDecimal(03065.91)
            ),
            Product(
                name = "Appetizer - Escargot Puff",
                description = "Bread - Bagels, Plain",
                price = BigDecimal(3321.61)
            ),
            Product(
                name = "Eggwhite Frozen",
                description = "Beef - Sushi Flat Iron Steak",
                price = BigDecimal(3906.51)
            ),
            Product(
                name = "Wine - Peller Estates Late",
                description = "Potatoes - Mini White BigDecimal( Oz",
                price = BigDecimal(15608.81)
            ),
            Product(
                name = "Squash - Pattypan, Yellow",
                description = "Wine - White, Gewurtzraminer",
                price = BigDecimal(3659.81)
            ),
            Product(
                name = "Monkfish Fresh - Skin Off",
                description = "Soup - Knorr, French Onion",
                price = BigDecimal(3408.31)
            ),
            Product(
                name = "Wine - Casillero Del Diablo",
                description = "Jello - Assorted",
                price = BigDecimal(3753.51)
            ),
            Product(
                name = "Ocean Spray - Ruby Red",
                description = "Towel - Roll White",
                price = BigDecimal(12918.51)
            ),
            Product(
                name = "Kahlua",
                description = "Mints - Striped Red",
                price = BigDecimal(1677.71)
            ),
            Product(
                name = "Vermouth - Sweet, Cinzano",
                description = "Fireball Whisky",
                price = BigDecimal(2150.91)
            ),
            Product(
                name = "Chicken - Whole",
                description = "Stock - Beef, Brown",
                price = BigDecimal(1375.81)
            ),
            Product(
                name = "Quinoa",
                description = "Wine - Pinot Noir Stoneleigh",
                price = BigDecimal(0478.91)
            ),
            Product(
                name = "Tofu - Firm",
                description = "Lid - High Heat, Super Clear",
                price = BigDecimal(4898.21)
            ),
            Product(
                name = "Wine - Tio Pepe Sherry Fino",
                description = "Remy Red",
                price = BigDecimal(29378.21)
            ),
            Product(
                name = "Tomatoes - Cherry",
                description = "Salami - Genova",
                price = BigDecimal(8516.21)
            ),
            Product(
                name = "Spring Roll Wrappers",
                description = "Bread - Multigrain Oval",
                price = BigDecimal(8036.21)
            ),
            Product(
                name = "Lamb - Whole Head Off",
                description = "Capon - Breast, Double, Wing On",
                price = BigDecimal(00483.31)
            ),
            Product(
                name = "Dc - Frozen Momji",
                description = "Star Anise, Whole",
                price = BigDecimal(3833.91)
            ),
            Product(
                name = "Onions - Spanish",
                description = "Smoked Tongue",
                price = BigDecimal(0820.01)
            ),
            Product(
                name = "Oranges",
                description = "Cream - BigDecimal(5%",
                price = BigDecimal(5108.51)
            ),
            Product(
                name = "Isomalt",
                description = "Salt - Celery",
                price = BigDecimal(7365.11)
            ),
            Product(
                name = "Bols Melon Liqueur",
                description = "Chocolate - Pistoles, White",
                price = BigDecimal(3857.71)
            ),
            Product(
                name = "Graham Cracker Mix",
                description = "Pepper - Yellow Bell",
                price = BigDecimal(11354.11)
            ),
            Product(
                name = "Tart - Lemon",
                description = "Cumin - Ground",
                price = BigDecimal(4633.41)
            ),
            Product(
                name = "Squash - Sunburst",
                description = "Steampan - Half Size Shallow",
                price = BigDecimal(35147.91)
            ),
            Product(
                name = "Oysters - Smoked",
                description = "Sping Loaded Cup Dispenser",
                price = BigDecimal(36795.31)
            ),
            Product(
                name = "Urban Zen Drinks",
                description = "Wine - Muscadet Sur Lie",
                price = BigDecimal(7199.71)
            ),
            Product(
                name = "Tomatoes - Heirloom",
                description = "Longos - Assorted Sandwich",
                price = BigDecimal(00030.61)
            ),
            Product(
                name = "Muffin - Zero Transfat",
                description = "Jam - Strawberry, BigDecimal(0 Ml Jar",
                price = BigDecimal(7500.51)
            ),
            Product(
                name = "Wine - Fume Blanc Fetzer",
                description = "Soup - Campbells Pasta Fagioli",
                price = BigDecimal(14255.21)
            ),
            Product(
                name = "Broom - Corn",
                description = "Beer - Sleeman Fine Porter",
                price = BigDecimal(8094.41)
            ),
            Product(
                name = "Cheese - Brick With Pepper",
                description = "Nut - Pine Nuts, Whole",
                price = BigDecimal(0960.71)
            ),
            Product(
                name = "Capers - Pickled",
                description = "Lamb - Bones",
                price = BigDecimal(12830.71)
            ),
            Product(
                name = "Island Oasis - Sweet And Sour Mix",
                description = "Crush - Orange, BigDecimal(55ml",
                price = BigDecimal(11350.01)
            ),
            Product(
                name = "Schnappes Peppermint - Walker",
                description = "Cheese - Shred Cheddar / Mozza",
                price = BigDecimal(38599.91)
            ),
            Product(
                name = "Bread - Italian Sesame Poly",
                description = "Wine - Red, Mouton Cadet",
                price = BigDecimal(8201.41)
            ),
            Product(
                name = "Crab - Dungeness, Whole",
                description = "Mints - Striped Red",
                price = BigDecimal(26065.01)
            ),
            Product(
                name = "Dried Peach",
                description = "Dc - Frozen Momji",
                price = BigDecimal(3908.11)
            ),
            Product(
                name = "Snapple - Mango Maddness",
                description = "Taro Root",
                price = BigDecimal(7280.21)
            ),
            Product(
                name = "Appetizer - Southwestern",
                description = "Chocolate - Milk",
                price = BigDecimal(00915.31)
            ),
            Product(
                name = "Lettuce - Lolla Rosa",
                description = "Vodka - Moskovskaya",
                price = BigDecimal(17230.61)
            ),
            Product(
                name = "Turkey - Breast, Bone - In",
                description = "Chocolate - Milk Coating",
                price = BigDecimal(46708.01)
            ),
            Product(
                name = "Tuna - Salad Premix",
                description = "Pepper - Chipotle, Canned",
                price = BigDecimal(41596.91)
            ),
            Product(
                name = "Cinnamon Rolls",
                description = "Lambcasing",
                price = BigDecimal(2511.61)
            ),
            Product(
                name = "Ham - Cooked Italian",
                description = "Coffee - Frthy Coffee Crisp",
                price = BigDecimal(11952.21)
            ),
            Product(
                name = "Apricots - Dried",
                description = "Mushrooms - Black, Dried",
                price = BigDecimal(5619.71)
            ),
            Product(
                name = "Vodka - Moskovskaya",
                description = "Yeast - Fresh, Fleischman",
                price = BigDecimal(4260.41)
            ),
            Product(
                name = "Glycerine",
                description = "Momiji Oroshi Chili Sauce",
                price = BigDecimal(0612.81)
            ),
            Product(
                name = "Grand Marnier",
                description = "Nut - Almond, Blanched, Whole",
                price = BigDecimal(41960.51)
            )
        )
    }
}