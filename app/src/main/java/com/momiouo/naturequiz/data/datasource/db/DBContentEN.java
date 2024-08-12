package com.momiouo.naturequiz.data.datasource.db;

import androidx.sqlite.db.SupportSQLiteDatabase;

public class DBContentEN {

    public void insertTopNews(SupportSQLiteDatabase db){
        //---------------------------------Les Top news en anglais
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"What is the name of the movement which aims to collect plastic in the oceans?\"," +
                " 1,\"The ocean cleanup\",\"Clean the pacific\",\"Ocean cleaner\"," +
                "\"It is a non-governmental organization that is developing a technology to extract plastic pollution from the oceans.\"," +
                "\"The organization conducts scientific research on ocean plastic pollution. They led two expeditions in the subtropical North Pacific Gyre and published scientific papers. They predict that this capability could clean up 50% of the debris in the North Pacific Waste Vortex within five years.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"What is the name of the founder of ocean cleanup?\"," +
                " 1,\"Boyan Slat\",\"Jeff Bezos\",\"Donald Duck\"," +
                "\"He is of Croatian origin.\"," +
                "\"The organization was founded in 2013 by Boyan Slat, a Dutch inventor-entrepreneur of Croatian origin who is the CEO.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"How many trees have been planted using the Ecosia search engine in ten years?\"," +
                " 3,\"100 thousand\",\"50 billion\",\"100 million\"," +
                "\"In January 2018, the number of trees planted by Ecosia exceeded 20 million.\"," +
                "\"For eleven years, the search engine Ecosia has used most of its income in advertising on its website and app to plant trees. And this month(July 2020), they planted their 100 millionth tree.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Which of these species have come out of “endangered” status?\"," +
                " 2,\"The great shark\",\"The gray whale\",\"The gorilla\"," +
                "\"This species lives in water.\"," +
                "\"Almost extinct at the beginning of the 20th century, the gray whale had become a protected species in 2017. Completely disappeared from the Atlantic Ocean due to intensive fishing, a population of about 20,000 individuals still exists in the Pacific Ocean . From the status of “endangered”, it has thus passed to that of “least concern”. A feat.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"What is the increase in the population of the giant panda in 10 years?\"," +
                " 1,\"17% of its population\",\"34% of its population\",\"5% of its population\"," +
                "\"In the 1980s, there were only 1,114 pandas in China. But the last census carried out in 2013 reveals that there are now 1,864 pandas living in the wild.\"," +
                "\"In the 1980s, there were only 1,114 pandas left in the wild in China. In the 2000s, they were around 1,600. Today, there are 1,864 in the world thanks to the conservation efforts of its range! However, there is still a lot to be done to put the panda permanently free from any threat as its population remains low.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Is it true that farmers use onion supplements to control cow gas?\"," +
                " 2,\"True\",\"False\",\"Don't know\"," +
                "\"Cows produce methane, a chemical compound that is bad for the environment!\"," +
                "\"A new garlic-based dietary supplement given to cows has been shown in two different studies to reduce the methane content in cow droppings from 30% to 38%, which could help reduce it to 2.6 % of the volume of US greenhouse gases produced by cattle farming.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"What percentage of Americans admit to having made at least one positive change for the environment in 2018?\"," +
                " 2,\"50%\",\"85%\",\"20%\"," +
                "\"Four in ten said they had made a decision, environmentally conscious at least once a week, and nearly one in three reported doing it daily.\"," +
                "\"In an effort to be more environmentally friendly, 85% of Americans polled have made at least one positive lifestyle change in the past year. The good news is that a growing interest in becoming more environmentally friendly is a contagious movement: half of those polled said they made someone else be more environmentally friendly.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Is the Earth greener?\"," +
                " 1,\"True\",\"False\",\"Don't know\"," +
                "\"Earth is nicknamed the Blue planet.\"," +
                "\"According to a NASA study published in the journal Nature in 2020 February, the planet has grown green in recent years. Experts find that the Earth gained 5% of green surface between 2000 and 2017, the equivalent of the Amazon rainforest. We owe this progress mainly to China and India, with massive reforestation in the country for the first and the development of cultivated land for the second.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"In recent years, how many countries have reduced their CO2 emissions?\"," +
                " 3,\"7\",\"13\",\"18\"," +
                "\"Developed countries have reduced their CO2 emissions through the use of renewable energies.\"," +
                "\"18 developed countries reduced their CO2 emissions over the period 2005-2015, including France, the United Kingdom, Belgium, Italy and the United States. While in 2018, the global level of emissions increased by 2%, concerning these 18 countries, it decreased by 2.4% per year over this period. This figure can be explained in particular by the abandonment of fossil fuels in favor of renewable energies.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"What is the annual energy and water autonomy of the two independent buildings in Grenoble?\"," +
                " 1,\"70%\",\"90%\",\"60%\"," +
                "\"The building in question will use three times less water and energy from urban networks than normal housing.\"," +
                "\"The first ABC demonstrator in France is set up in the Ecocité Presqu'Île in Grenoble. This concept, whose acronym stands for “Autonomous Building for Citizens”, is the result of a research and development project led by Bouygues Construction and developed by Linkcity Sud-Est. A true concentrate of technologies aiming at zero energy balance and annual autonomy in energy and water of 70%.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"How many tons of greenhouse gases has the coronavirus prevented in China?\"," +
                " 1,\"200 million\",\"800 thousand\",\"50 million\"," +
                "\"Last year, China emitted 800 million tons of CO2 over the same period (after the New Year's holidays).\"," +
                "\"The coronavirus epidemic by slowing the economy has brought down air pollution in China. The coronavirus epidemic is said to have caused China's CO2 emissions to drop by 25% over the past four weeks (representing around 200 million tons of greenhouse gases).\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"What nationality is Greta Thunberg?\"," +
                " 2,\"Norwegian\",\"Swedish\",\"Russian\"," +
                "\"She is from a Scandinavian country.\"," +
                "\"Greta Thunberg, born January 3, 2003 in Stockholm, is a Swedish environmental activist committed to the fight against global warming.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"When did McDonald's France stop using plastic straws?\"," +
                " 2,\"September 2018\",\"November 2019\",\"January 2020\"," +
                "\"France is preparing for the total disappearance of plastic straws from 2021.\"," +
                "\"McDonald's France launched in November 2019, at the national level, an alternative solution, without straws. This is a molded paper fiber lid, recyclable, with a small drinking spout. It will allow an annual saving of 1,200 tons of plastic.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"What is the price per unit of Dior glass straws?\"," +
                " 3,\"40 €\",\"5 €\",\"22 €\"," +
                "\"The straws are in blown glass and painted by hand.\"," +
                "\"The French brand has developed a box of six hand-painted blown glass straws. The objects are adorned with gold and are sold in an elegant white and red box. A designer and designer straw that comes at a price: 130 euros per box of six straws, or 22 euros per straw!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Which city in France will host an urban forest?\"," +
                " 3,\"Strasbourg\",\"Annecy\",\"Lyon\"," +
                "\"It is part of the Auvergne Rhône-Alpes region.\"," +
                "\"The city of Lyon has decided to plant 4,500 to 6,000 trees in its 9th arrondissement. This forest should begin to emerge at the beginning of next fall. At the origin of the initiative: SACVL (Société anonyme de construction), a real estate operator, which hopes to offset the carbon footprint of the 200 homes it builds each year.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Which city is the European Green Capital 2022?\"," +
                " 1,\"Grenoble\",\"Turin\",\"Tallinn\"," +
                "\"With its agglomeration of 670,000 inhabitants, it is also the largest metropolis in the Alps, ahead of Innsbruck, whose metropolitan area has only 300,000 inhabitants, and Bolzano.\"," +
                "\"Grenoble was designated as the winner of the title of European Green Capital 2022. The Jury which took place on October 8 decided which of Grenoble, Turin, Dijon or Tallinn would be the ambassador of the transitions in 2022.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Each year , the forest absorbs how many carbon emissions on a global scale?\"," +
                " 2,\"Between 5% and 8%\",\"Between 10% and 15%\",\"Between 35% and 45%\"," +
                "\"Deforestation and forest degradation are responsible for 11% of global greenhouse gas emissions.\"," +
                "\"The forest constitutes a real carbon sink since it allows the storage of atmospheric CO2. Each year, it absorbs between 10 and 15% of carbon emissions worldwide. Trees can mitigate the effects of climate change by playing a role on several levels: 1 cubic meter of oak wood absorbs a ton of CO2. The forest plays a key role in mitigating and combating climate change.\");");

    }

    public void insertDonneesCles(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"How much percentage of the earth's surface is dedicated to agriculture and livestock?\"," +
                " 2,\"56%\",\"33%\",\"26%\"," +
                "\"In France, the UAA (used agricultural area) represents 54% of the national territory.\"," +
                "\"Despite this high percentage which represents 49 million km² (approximately the area of ​​Asia), many countries suffer from undernourishment ...\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"What is the size of the largest garbage vortex?\"," +
                " 1,\"1.6 million km\",\"130,000 km\",\"1.2 million km\"," +
                "\"It is made up of 80,000 tons of plastic waste.\"," +
                "\"It's a plastic dump that floats between Japan and the United States. It represents 1.6 million km ².\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"What is the percentage of recycled or composted waste?\"," +
                " 3,\"24%\",\"35%\",\"19%\"," +
                "\"37% are buried underground, 33% are left in the open & 11% are incinerated.\"," +
                "\"Today, the vast majority of municipal waste is landfilled. Recycling is still a prerogative of rich countries In low income countries, 93% of waste ends up in more or less well managed open-air landfills.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Which country uses renewable energies the most?\"," +
                " 2,\"Norway\",\"Iceland\",\"Sweden\"," +
                "\"Island in the North Atlantic Ocean, north-west of the Faroe Islands.\"," +
                "\"Iceland is currently the only nation where 100% of the energy it consumes is said to be green and renewable. The share of renewable energy consumption in France is around 16%. Nuclear power, petroleum products and gas remain its main sources of energy. With the law relating to energy transition for green growth, promulgated on August 18, 2015, France has set itself the objective of reaching 32% of renewable energies in France's total energy consumption by 2030.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"What is the most widely used renewable energy in France?\"," +
                " 2,\"Hydraulic\",\"Wood\",\"Wind\"," +
                "\"It is a renewable energy used as fuel.\"," +
                "\"In France, the use of wood in the share of renewable energies is 41.2%, hydro 19.8% and wind power 7.1%\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"What is the number of trees cut each year on Earth ?\"," +
                " 1,\"15 billion trees\",\"60 million trees\",\"4 billion trees\"," +
                "\"A study carried out in 2015 showed that there were approximately 3,400 billion trees on our planet.\"," +
                "\"Since the beginnings of agriculture, around 12,000 years ago, the number of trees on Earth has dropped by 46%! And with them, a whole biodiversity, animal and plant species, some of which have disappeared forever…\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"By how much has the global temperature increased since 1900?\"," +
                " 3,\"1.5 ° C\",\"2.0 ° C\",\"1.0 ° C\"," +
                "\"Winter cold spells in much of the northern hemisphere are lasting two weeks less than 100 years ago.\"," +
                "\"Global warming is causing a lot of damage and in particular melting ice: since the end of the 1960s, global snow cover has decreased by around 10 to 15%. If the glaciers were all to melt, the ocean level would rise by about 40 cm.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"Which city is the least polluted in France?\"," +
                " 3,\"Grenoble\",\"Albertville\",\"Roisey\"," +
                "\"It is not always the towns surrounded by mountains / countryside that look the purest.\"," +
                "\"City or countryside, pollution has no borders. Three criteria must be taken into account: pollutant emissions, topography (plains, mountains, coastal areas, etc.) as well as weather conditions.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"In 2017, What was the power developed by the French wind farm?\"," +
                " 3,\"14.3 GW\",\"60.8 GW\",\"13.6 GW\"," +
                "\"3 regions account for almost 60% of electricity production from national wind power. These are Grand-Est (3.1 GW), Hauts de France (3.36 GW) and Occitanie (1.4 GW).\"," +
                "\"Germany has the largest fleet (108 GW) ahead of Italy (60.8 GW) and Spain (51.9 GW). The French fleet is the fourth largest in Europe with 13.6 GW of installed capacity in 2017 (there are 6,500 wind turbines installed in France).\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"In m3, what is the reservoir volume of the Petit-saut dam in Guyana?\"," +
                " 3,\"1,500,000,000\",\"985,000\",\"3,500,000,000\"," +
                "\"The Petit-saut dam has an area of ​​310 km².\"," +
                "\"The Petit-saut dam is 37 m high for an area of ​​310km². Its reservoir volume in millions of m3 is 3500. It is the largest French dam!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"In 2018, What was the market share for electric vehicles in France?\"," +
                " 1,\"2.2%\",\"46.7%\",\"5.4%\"," +
                "\"France has not yet taken the leap for electric vehicles.\"," +
                "\"In France, electric cars represented 2.2% (2018) of the French market, compared to 46.7% in Norway and 6.6% in the Netherlands.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"On Earth, What is the percentage of salt water?\"," +
                " 2,\"91.7%\",\"97.5%\",\"80.3%\"," +
                "\"On Earth, there are 35.2 million billion cubic meters of freshwater.\"," +
                "\"Only 2.5% of the water is freshwater, or around 35.2 million billion cubic meters of freshwater. This amount of freshwater is found: 68.7% in glaciers, 30.1% in groundwater, 0.8% in permafrost (frozen rock) and 0.4% in the atmosphere. Ultimately, less than 1% of the water on Earth is soft, liquid water.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"How many billion cubic meters of fresh water does Lake Baikal contain?\"," +
                " 1,\"23,000\",\"5,000\",\"32,000\"," +
                "\"Its area is 31 722km² (approximately that of Belgium) and its average depth is 744 m.\"," +
                "\"Lake Baikal, with its 23,000 billion cubic meters of water, is the largest reservoir of liquid freshwater on the planet's surface. It is classified as World Heritage of Humanity for the richness of the fauna it shelters.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"What is the percentage of oxygen that the Amazon provides on Earth?\"," +
                " 2,\"50%\",\"20%\",\"10%\"," +
                "\"The Amazon is 10% of the world's biodiversity\"," +
                "\"Lung of the planet, the Amazon is : 6.7 million km² of forests, 17 to 20% of the world's fresh water and 20% of the oxygen on earth.\");");
    }

    public void insertLesDechetsEtLaDecomposition(SupportSQLiteDatabase db){

    }

    public void insertLesBases(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"What is recycling?\"," +
                " 1,\"Recover waste and reintroduce it, after treatment\",\"Incinerate waste.\",\"Resell products already used without transforming them.\"," +
                "\"Recycling is a waste treatment process\"," +
                "\"Recycling reduces waste volumes and preserves natural resources by reusing raw materials already extracted.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"What is renewable energy?\"," +
                " 1,\"An inexhaustible energy\",\"An energy which takes time to renew itself\",\"An energy good for health\"," +
                "\"It is not because it is good for the planet that it is good for health.\"," +
                "\"Renewable energies (RE) are energy sources whose natural renewal is fast enough that they can be considered inexhaustible on the human time scale. They come from natural phenomena (Sun, Moon (tides), Wind ...).\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"How does an electric vehicle work?\"," +
                " 2,\"With alternating current electricity\",\"With a battery\",\"With a battery and oil to cool the engine\"," +
                "\"Its operation is much simpler than a diesel or gasoline car.\"," +
                "\"the electric car does not have a gearbox. It is unnecessary because an electric motor is able to operate without problem up to several tens of thousands of revolutions per minute. It directly provides rotation unlike a heat engine.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Which of these technologies generates electricity from the wind?\"," +
                " 3,\"Solar photovoltaic\",\"Hydraulic\",\"Wind turbine\"," +
                "\"Thank you for clicking on me for this question, I thought I was useless.\"," +
                "\"Wind energy represents 7.1% of the renewable energies used in France, solar photovoltaic 2.7% and hydraulics 19.8%.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"What is pollution?\"," +
                " 1,\"Environmental degradation\",\"Sky degradation\",\"Health degradation\"," +
                "\"Although it degrades human health, it is not part of its definition.\"," +
                "\"Pollution is the degradation of the environment by substances, waste or various nuisances. Although it may have an entirely natural origin (volcanic eruption), it is mainly linked to human activities.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"What is one of the consequences of deforestation among these proposals?\"," +
                " 2,\"Appearance of new species\",\"Global warming\",\"Lack of paper\"," +
                "\"We will see it in the long term.\"," +
                "\"Deforestation has a very strong impact on climate change. trees store CO2 throughout their life. By destroying these trees, we reduce the capacity of the global ecosystem to store CO2.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"What is extensive agriculture?\"," +
                " 3,\"Agricultural production seeking to maximize production.\",\"Agricultural production which has an impact on the environment\",\"Agricultural production based on the use of natural resources.\"," +
                "\"Extensive agriculture is the opposite of intensive agriculture.\"," +
                "\"Extensive livestock farming is a type of livestock farming which is essentially based on the use of available natural resources: water, pasture, etc. The production system is based on grazing. It is generally practiced in large spaces to which animals access by moving. It's about producing a little less, but better.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Who is nicknamed the green lung of the planet?\"," +
                " 1,\"The Amazon rainforest\",\"The Taiga, a huge polar forest\",\"The Daintree forest in Australia\"," +
                "\"It covers nearly 6 million km2. This does not represent less than 400 billion trees.\"," +
                "\"Almost two thirds of its surface is in Brazil, but it also affects eight other countries, including France, through Guyana. And it is a UNESCO World Heritage Site. Unfortunately, this treasure is threatened by deforestation. Between August 2015 and July 2016, for example, no less than 8,000 km2 of forest were destroyed.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Where is the Great Barrier Reef?\"," +
                " 3,\"Ridge\",\"Mauritius\",\"Australia\"," +
                "\"It covers 344,400 km², the Great Barrier is located off Queensland in the Coral Sea.\"," +
                "\"Located in the Pacific Ocean, Australia's Great Barrier Reef is the largest coral system and the largest living structure on the planet. It is one of the Seven Natural Wonders of the World.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"What is a reef?\"," +
                " 2,\"A plant in the sea\",\"A chain of rocks\",\"A fish\"," +
                "\"A reef is a natural structure.\"," +
                "\"The reef can be either a chain of rocks (on the surface of the water or submerged), or a structure created by the accumulation of certain living marine organisms, the best known of which are the coral reefs of tropical seas.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"What is a coral?\"," +
                " 1,\"An animal that lives in warm seas\",\"A rock\",\"Vegetation\"," +
                "\"By assembling, corals form coral reefs that shelter 25% of the marine life of our planet.\"," +
                "\"Coral is an animal of the cnidarian family that often lives in colonies in warm seas. It has an orifice surrounded by tentacles that allow it to capture prey for food. Coral makes a hard, calcareous outer skeleton that helps build a coral reef. Today, coral is under threat around the world due to global warming. Coral can be of different colors. There is in particular the red coral.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"What is global warming?\"," +
                " 3,\"Phenomenon of rising sea level.\",\"Phenomenon of increased greenhouse effect.\",\"Phenomenon of increase in average temperatures.\"," +
                "\"Be careful among these answers, some are consequences of warming.\"," +
                "\"Global warming is the phenomenon of an increase in average ocean and atmospheric temperatures, due to excessive greenhouse gas emissions.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"What is Biodiversity?\"," +
                " 1,\"All living species on Earth\",\"Human beings\",\"Human beings and animals\"," +
                "\"Fauna and flora\"," +
                "\"Biodiversity is all the cash live and  diversity is biological. It encompasses the diversity of  genes, cash and ecosystems. She understands also the made than these levels interact.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Is pollination the disappearance of bees?\"," +
                " 2,\"True\",\"False\",\"Don't know\"," +
                "\"The most emblematic pollinators and best known to the general public are the honey bee.\"," +
                "\"Pollination consists of the action of transporting pollen in order to fertilize plants.\");");
    }

    public void insertLesAnimaux(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"What is the number of new species discovered in the world each day?\"," +
                " 2,\"15\",\"50\",\"150\"," +
                "\"About 18,000 new species are discovered each year.\"," +
                "\"We discover almost 50 new species per day on average. Discoveries which, however, do not compensate for the complete disappearance of other species of plants or animals.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"How many turtles were born during confinement in 2020 on the Paulista coast in Brazil?\"," +
                " 2,\"52\",\"97\",\"74\"," +
                "\"While nearly a billion people were confined in the world, animals were able to benefit from this respite. 291 turtles were born on the Paulista coast in 2020\"," +
                "\"Spared by the usually numerous walkers, 97 eggs have hatched. The species only breeds every two or three years in some 40 countries and territories in the Caribbean region as well as in Brazil\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"How many African elephants are left in the wild ?\"," +
                " 1,\"415,000\",\"200,000\",\"20,000\"," +
                "\"Elephant tusks attract the lust of poachers causing the death of 20,000 to 30,000 elephants each year.\"," +
                "\"Elephant populations fell between the 19th and 20th centuries. The species now numbers around 415,000 individuals against 3 to 5 million at the start of the 20th century\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"How many flowers can a bee colony pollinate per day?\"," +
                " 3,\"10 miles\",\"200 billion\",\"300 million\"," +
                "\"A teaspoon of honey represents 499 trips to collect nectar, 49,900 flowers visited and 760 km traveled by a honey bee.\"," +
                "\"A colony can pollinate 300 million flowers per day & help 90% of wild plants to thrive.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"What is the most endangered species?\"," +
                " 1,\"The Great Shark\",\"The Asian Elephant\",\"The Bengal Tiger\"," +
                "\"It belongs to the order of the lamniformes, it is a formidable predator.\"," +
                "\"Over the past 15 years, the population of great white sharks has declined by almost 80%. Each year, more than 100 million sharks are killed.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"How many species of fish are there in the Great Barrier Reef?\"," +
                " 1,\"1625\",\"54\",\"723\"," +
                "\"The coral reef covers nearly 133 species of sharks and rays.\"," +
                "\"The Great Barrier Reef is the largest living structure in the world! It brings together 1,625 species of fish, 600 species of corals and 133 species of sharks and rays on more than 3,000 reefs and 600 islands.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"How long is the Great Barrier Reef in Australia?\"," +
                " 2,\"1000 meters\",\"2300 km\",\"5000 km\"," +
                "\"The Great Barrier Reef is visible from space, it is the largest living structure in the world.\"," +
                "\"The Great Barrier Reef deserves its name. With its 3000 reefs that stretch for nearly 2300 km along the east coast of Australia. It covers 344,000 km² (almost the surface of Germany).\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Where does the nectar come from?\"," +
                " 1,\"The flower\",\"The hive\",\"The bee\"," +
                "\"Bees collect nectar from nature.\"," +
                "\"Plants secrete nectar. This liquid is then collected by the bee. Once back at the hive, the bee regurgitates the nectar. This is again swallowed by other bees before being placed in cell wax. The work ends thanks to the ventilating bees which will further dry the preparation. When the water content of the nectar falls below 20%, the insect seals the cell and the honey is thus preserved.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"What is the percentage of bee losses each winter in France?\"," +
                " 3,\"5 to 10%\",\"70 to 75%\",\"25 to 30%\"," +
                "\"This species, so necessary for life on Earth, has nevertheless been decimated by humans.\"," +
                "\"In France, bees suffer losses of 25 to 30% each winter. This study is indicative of a significant disruption of our ecosystem. According to figures released by Greenpeace in 2016, bees contribute 75% of global food production through pollination. Without pollinating insects, we could give up apples, artichokes, onions, lemons and other papillary pleasures.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"In how many years has the shark population declined by 80%?\"," +
                " 2,\"5 years\",\"15 years\",\"40 years\"," +
                "\"According to WWF, more than 100 million sharks are killed each year.\"," +
                "\"More than 100 million sharks, from 380 different species, are killed each year. The hunters take the fins, but also the flesh, skin and cartilage, used in medicine. Water pollution, which disrupts reproduction cycles, is also responsible for the decline of the species.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"How much of the area of ​​koala habitat was destroyed in the 2019/2020 fires in the Southeast region of Australia?\"," +
                " 1,\"30%\",\"5%\",\"60%\"," +
                "\"Almost 30% of the koalas in the southeast may have been killed in the fires.\"," +
                "\"The koalas were already threatened with extinction, and went from several million in the last century to a few tens of thousands, the consensus figure is 28,000. The loss would amount to a third of the population (10,000). The consequences on koalas are particularly important because if animals such as kangaroos, deer, or even dingoes (wild dogs) can flee, this is not the case for koalas, who find themselves climbing up trees. in fire.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"What percentage of species in nature remain unknown?\"," +
                " 3,\"25%\",\"60%\",\"90%\"," +
                "\"71 new species were identified around the world in 2019.\"," +
                "\"pecialists Biodiversity estimate that more than 90% of species in nature remain unknown. A rich diversity of plants and animals, which allows life on our planet to thrive.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Which of these species was discovered in 2017?\"," +
                " 1,\"The giant rat Vangunu\",\"Homo Naledi\",\"The Komodo dragon\"," +
                "\"The Komodo dragon is a species of lizard that was discovered in 1912.\"," +
                "\"The inhabitants of the Solomon Islands have long spoken of the giant rat Vangunu of nearly a kilo that feeds on coconuts, but no scientist had ever confirmed its existence ... before a ranger caught one escaping from a tree that loggers were coming from tear down.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"How much will decrease the population of polar bears by 2050?\"," +
                " 1,\"66%\",\"44%\",\"22%\"," +
                "\"It is estimated that the species could disappear within a century because of the reduction in the area and the quality of its habitat.\"," +
                "\"The future of this predator is unfortunately known. The Arctic sea ice where the animal hunts gradually disappears during the summer. The pack ice is reforming later in the fall and melting earlier and earlier in the spring. According to some reports, polar bears might as well come ashore to feed on terrestrial food, and thus do without the ice floes. But we have no evidence that they can.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Which of these animals is also responsible for the pollution?\"," +
                " 2,\"chien.jpg\",\"vache.jpg\",\"elephant.jpg\"," +
                "\"It is a herbivore.\"," +
                "\"The cow produces methane by farting, it is a very harmful greenhouse gas French cows emit as much gas in a year as 15 million cars!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"What is the oldest animal still living on Earth?\"," +
                " 3,\"crocodile.jpg\",\"mathusalem.jpg\",\"coelacanthe.jpg\"," +
                "\"It is found in the Indian Ocean.\"," +
                "\"It is the coelacanth (a large carnivorous fish whose oldest fossil dates back to 400 million years), which was believed to have disappeared 70 million years ago. Paleontologists were therefore amazed to find one alive in 1938, on the coast of South Africa. Since then, around 200 specimens have been caught in the Indian Ocean.\");");
    }

    public void insertTopNewsLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"In the Philippines how many trees students must plant in order to be graduate?\"," +
                " 1,\"10 trees\",\"1 trees\",\"5 trees\"," +
                "\"In the Philippines students must plant more than one tree in order to be graduate.\"," +
                "\"Under a new law, students that are graduating primary school, high school & university must plant 10 trees each before they can graduate. The trees can be planted in either forests, mangroves, reserves, urban areas, abandoned mining sites or indigenous territory.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Last year, which country was the most implicated for ecology ?\"," +
                " 1,\"Switzerland\",\"France\",\"Danmark\"," +
                "\"it’s a mountainous Central European country.\"," +
                "\"It was Switzerland with a first place in terms of ecology in the world in 2019 according to the IPE. Countries are judged on the criteria of air pollution, water quality, management of natural resources ...\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"In 2016, Bhutan (a small country next to India) removes more carbon than it produces ?\"," +
                " 1,\"true\",\"false\",\"don’t know\"," +
                "\"Bhutan produced 2.2 million tons of CO2.\"," +
                "\"In 2016, Bhutan (a small country next to India) produced 2.2 million tons of CO2. However, their forests removed 3 x this amount, making them a carbon sink for 4 million tons of CO2 per year.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"From what date will sales of diesel and petrol cars be banned in California?\"," +
                " 2,\"2025\",\"2035\",\"2050\"," +
                "\"In a decade, sales of diesel and gasoline cars will be banned.\"," +
                "\"Against air pollution and global warming, the Democratic governor of California takes the bull by the horns: from 2035, sales of diesel cars and new gasoline will be purely and simply banned.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Will it still be possible to head to a heated terrace for a drink in France in 2021?\"," +
                " 2,\"True\",\"False\",\"Don’t know\"," +
                "\"As of the end of winter 2021 this decision may be implemented.\"," +
                "\"It will soon no longer be possible to go to a heated terrace for a drink or to enjoy a dish outside. This is the decision taken by the French government on Monday July 27, 2020.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Thanks to the health crisis in early 2020, how many weeks did the day of the overflow of the earth’s resources recede?\"," +
                " 3,\"1 week\",\"5 weeks\",\"3 weeks\"," +
                "\"For the first time since the 1970s, “Earth’s Passing Day” is delayed.\"," +
                "\"The pandemic will have had at least one positive effect: with air traffic paused, transport and industry stopped, the planet was able, for a few months, to breathe again. As a result, for the first time since the 1970s, “Earth’s Passing Day” is delayed.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Had the Elephant shrew really disappeared?\"," +
                " 2,\"True\",\"False\",\"Don’t know\"," +
                "\"The animal, similar to a mouse, lives in rocky areas of the Horn of Africa.\"," +
                "\"The animal, similar to a mouse, was listed as one of the Global Wildlife Conservation’s 25 Most Wanted Lost Species. It must be said that since 1973, the insectivore seemed to have died out, at least that’s what scientists thought. In reality, the Elephant Shrew (or Elephantulus Revoilii) continued to live its life, away from man, in rocky areas of the Horn of Africa.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Which company manufactured the first hydrogen train?\"," +
                " 3,\"TrainCompany\",\"H2OFaster\",\"Alstom\"," +
                "\"The train was manufactured by a French company.\"," +
                "\"Manufactured by the French company Alstom, the first hydrogen train is now in circulation in Germany. Connecting the towns of Cuxhaven, Bremerhaven, Bremervörde and Buxtehude over a distance of 100 kilometres, this train can accommodate 300 passengers and travel at 140km/h. The advantage is that it emits only water vapour from a fuel cell that converts hydrogen in gaseous form into electricity.\");");

    }

    public void insertChiffreClesLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"What is the altitude of Mount Everest?\"," +
                " 1,\"8849 m\",\"4810 m\",\"6699 m\"," +
                "\"Everest is the roof of the world!\"," +
                "\"With an altitude of almost 8850 m, Everest is the roof of the world. Mont Blanc, the highest peak in Europe, barely reaches 4,810 m.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"The earth was born about ...?\"," +
                " 2,\"4.5 million years\",\"4.5 billion years\",\"550,000 years\"," +
                "\"Based on current knowledge, the age of the Earth is (4,54 x 109 years ± 1 %).\"," +
                "\"The Earth was a cloud of gas and dust which slowly condensed under the action of the forces of gravity. Scientists call this phenomenon “accretion”.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"After how many years are volcanoes that have not erupted called “extinct” volcanoes?\"," +
                " 3,\"100 years\",\"6000 years\",\"10000 years\"," +
                "\"A volcano is considered asleep when it last erupted between 10,000 years and a few hundred years ago.\"," +
                "\"You have to wait several thousand years to know if a volcano is extinct or just asleep. And that remains uncertain. In 1973, a volcano near Iceland erupted after more than 5,000 years of sleep!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"How high is the “Olympus Mons ” volcano on Mars?\"," +
                " 1,\"22.5 km\",\"15.2 km\",\"1514 m\"," +
                "\"Olympus Mons measures Mont Blanc more than 5 times!\"," +
                "\"Mars exhibits the largest volcano in the solar system. But nothing to fear for our future explorers: all these volcanoes have been extinct for several million years.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"What is the longest day of the year in the northern hemisphere?\"," +
                " 2,\"December 21\",\"June 21\",\"March 21\"," +
                "\"This date is called the summer solstice.\"," +
                "\"This date is called the summer solstice. The northern hemisphere receives the most sunlight. And during the winter solstice, December 21, we have the shortest day of the year. While in the southern hemisphere it is the opposite!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"What is the “absolute zero”?\"," +
                " 3,\"-0 ° C\",\"0 ° C\",\"-273.15 ° C\"," +
                "\"Scientists use this term very frequently.\"," +
                "\"The “absolute zero” corresponds to a temperature of -273.15 ° C therefore well below 0 ° C. It is in fact the zero of the Kelvin thermometric scale that scientists use very frequently.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Oceans and seas cover a large part of the earth's globe. They occupy ?\"," +
                " 1,\"About 70% of the total surface\",\"About 60% of the total surface\",\"About 55% of the total surface\"," +
                "\"The Earth is called the “blue planet” because it is mainly made up of water.\"," +
                "\"Oceans and seas cover 71% of our planet's surface. They constitute, among other things, a heat reservoir which circulates thanks to sea currents (see GulfStream-> CommunautyQuizzes).\");");

    }

    public void insertLesBasesLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"What are the three essential pillars of sustainable development?\"," +
                " 1,\"Economic, Social and Environment\",\"Economic, Health and Environment\",\"Economic, Justice and Environment\"," +
                "\"The social pillar has a liveable and equitable aspect.\"," +
                "\"Sustainable development is development that meets the needs of present generations without compromising the ability of future generations to meet theirs.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"What is the largest desert in the world?\"," +
                " 2,\"The Nevada Desert\",\"The Sahara Desert\",\"The Gobi Desert\"," +
                "\"The surface area of ​​the Gobi Desert is 1.295 million km ².\"," +
                "\"The Sahara covers 8 million square kilometers. It is 15 times the area of ​​France!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"The amplitude between the highest level and the lowest sea level in the bay of Mont-Saint-Michel corresponds to building of?\"," +
                " 3,\"ten floors\",\"one floor\",\"five floors\"," +
                "\"The difference between the two levels can exceed fifteen meters.\"," +
                "\"During strong fortnightly tides, the difference between low and high tide can exceed fifteen meters! And as the land is very flat, the sea then retreats to about twenty kilometers at low tide.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"With what scale do we measure the energy released by an earthquake?\"," +
                " 1,\"The Richter scale\",\"The Newton scale\",\"The Parker scale\"," +
                "\"The Newton scale is a scale for measuring temperature.\"," +
                "\"The Richter scale was developed by the American seismologist Charles Richter in 1935. It indicates the magnitude, which measures the energy released by the earthquake.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"What is a so-called “primary” forest?\"," +
                " 2,\"Is less than 10 years old\",\"Has never been influenced by humans\",\"Is found in the plains or at low altitude\"," +
                "\"Primary forests are particularly protected.\"," +
                "\"In primary / primitive forests, nature evolves without human impact. These forests are particularly protected because they constitute a precious heritage, serving as a research laboratory and conservatory of plants and animals.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"What can we say about the dimensions of a river compared to those of a stream?\"," +
                " 3,\"A river is always longer than a stream\",\"A river is always wider than a stream\",\"They cannot distinguish a river from a stream.\"," +
                "\"A river is not particularly wider than a stream.\"," +
                "\"The length or the width does not differentiate a river from a stream but it is the place on which they emerge: a river flows into the sea while a stream flows into a river or into another stream.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"At which temperature does sea water freeze?\"," +
                " 1,\"-2 ° C\",\"2 ° C\",\"0 ° C\"," +
                "\"The salinity of seawater impacts the freezing point of water.\"," +
                "\"Fresh water freezes at 0 ° C, but the salinity of seawater lowers its freezing point to -2 ° C.\");");
    }
    public void insertAnimauxLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Why aren't fish cold in water?\"," +
                " 3,\"Its scales protect it from the cold\",\"Its temperature is lower than that of water\",\"Its temperature is about the same as that of water.\"," +
                "\"Fish are animals of variable temperature.\"," +
                "\"Fish are animals of variable temperature, that is to say, in adequacy with that of the water in which they live.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"The pterodactyl lived 150 million years ago. It was flying over Europe, Africa and Asia. It was a ?\"," +
                " 1,\"Flying Reptile\",\"Dinosaur\",\"Bird\"," +
                "\"Dinosaurs only move on land.\"," +
                "\"Dinosaurs only move on land. They don't fly and don't swim! As for birds, their ancestors are dinosaurs.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Sloths have greenish fur. Do you know why ?\"," +
                " 3,\"The leaves of trees rub off on their coats\",\"Sloths are vegetarians and sweat a green liquidGreen\",\"algae grows on their fur\"," +
                "\"sloths must hide in trees.\"," +
                "\"Sloths are mammals from South America that live in trees and move very slowly. Not being able to flee at high speed, this adornment is a good camouflage against their enemies.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"When a person has very good eyesight, he is said to have eyes of ...?\"," +
                " 2,\"Beef\",\"Lynx\",\"Doe\"," +
                "\"She has the eyes of a carnivore.\"," +
                "\"The Lynx is a strong and agile carnivorous mammal which does not have a very good sense of smell but which, on the other hand, has keen eyesight and excellent hearing.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"In The Lion King, Pumbaa, Simba's friend, is a?\"," +
                " 3,\"guinea pig\",\"Meerkat\",\"Warthog\"," +
                "\"Pumbaa is a cousin of the wild boar.\"," +
                "\"A warthog is a wild African pig, cousin of the boar. Whereas a meerkat is kind of a little mongoose.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Krill is an important food source for whales, seals and birds in Antarctica. What is it?\"," +
                " 1,\"A school of tiny crustaceans\",\"A group of green algae\",\"A school of microscopic fish\"," +
                "\"Krill is a group of very small species.\"," +
                "\"Before being eaten in turn, krill crustaceans feed on marine plants and tiny animals. When they are gathered in shoals, the ocean appears red.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"How do snake charmers charm these reptiles?\"," +
                " 3,\"Thanks to the sounds produced by the flute\",\"By staring them in the eyes\",\"By waving the flute in front of them\"," +
                "\"Snakes are deaf.\"," +
                "\"Snakes are deaf. When the charmers wave their flute in front of the snakes, they think they are being attacked. They arch themselves in a defensive position and move while following the flute they take for a predator.\");");
    }


    }
