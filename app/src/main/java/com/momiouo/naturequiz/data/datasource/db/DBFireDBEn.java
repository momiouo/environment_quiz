package com.momiouo.naturequiz.data.datasource.db;

import androidx.sqlite.db.SupportSQLiteDatabase;

public class DBFireDBEn {
    public void insertDecentralisation(SupportSQLiteDatabase db) {
        //Datacenter 1
        String exotypeqcm = "exotypeqcmen";//Db anglaise
        String decentralisation = "digital";
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"What does a datacenter contain?\"," +
                " 1,\"Servers, storage bays,...\",\"Different varieties of plant species\",\"Letters, mails, ...\"," +
                "\"data centers use a lot of electricity.\"," +
                "\"A datacenter regroup together equipment (mainframe computers, servers, storage bays, network and telecommunications equipment, etc.). It provides services IT in a controlled environment (air conditioning) and security (anti-system fire, against theft and intrusion, etc.).\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"What is the percentage of global greenhouse gas emissions from data centers?\"," +
                " 2,\"1.2%\",\"0.3%\",\"2.6%\"," +
                "\"Answer 3 is not the correct answer.\"," +
                "\"Data centers are responsible for 0.3% of global greenhouse gas emissions. Data centers represent less than 15% of the environmental impact of digital on a global scale, while user equipment accounts for two thirds, and the network the remaining part. Recall that, according to the French association The Shift Project, digital technology as a whole was responsible for 3.7% of CO2 global emissions in 2018, against 2.5% in 2013.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"What is dematerialization?\"," +
                " 3,\"Disappearance of hardware media\",\"Replacement of computer files by hardware media\",\"Replacement of hardware media by computer files and computers\"," +
                "\"The concept of dematerialization is to replace hardware media.\"," +
                "\"The dematerialization is the replacement in a company or organization of its information supporting material(often paper) by computer files and computers.We also speak of computerization or digitization.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"What is dematerialization for?\"," +
                " 1,\"Save time and human resources\",\"Better reforestation of the Earth\",\"Less polluting\"," +
                "\"Dematerialization mainly concerns the productivity aspect.\"," +
                "\"The dematerialisation or scanning, which is to virtualize paper documents, becomes an important tool for business productivity. Indeed, dematerialization saves time, human resources and therefore money. source: cpro.fr\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"How many grams of CO2 does storing an email for a year emit?\"," +
                " 3,\"100\",\"50\",\"10\"," +
                "\"1 tree absorbs 5kg of CO2 per year\"," +
                "\"A French receives an average of 39 messages per day. Sending an email with an attachment can emit 19g of CO2. Storing an email in a data center for a year emits 10g of CO2. Thus, an email results in the emission of 30 grams of CO2. And in the world, 281 billion emails are sent every day. source: leshorizons.net\");");
        //Fin Datacenter 1

        //Datacenter Kolos
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"How many direct jobs will be brought to Ballangen thanks to the Kolos datacenter?\"," +
                " 1,\"2000 to 3000\",\"More than 5000\",\"500 to 1000\"," +
                "\"The Kolos data center will generate indirectly 10,000 to 15,000 jobs thanks to the relocation of people to the dynamic community of Ballangen.\"," +
                "\"Kolos is a community project. Supported by five mayors from the region, the new Kolos center will directly create 2,000 to 3,000 new jobs and generate 10,000 to 15,000 jobs through the relocation of people to the vibrant community of Ballangen.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Why was Ballangen chosen to build the world's largest data center?\"," +
                " 2,\"Cool and unstable North climate\",\"Cool and stable North climate\",\"Temperate and stable Europe climate\"," +
                "\"Ballangen is a former municipality in the county of Nordland, Norway\"," +
                "\"The cool and stable climate of northern Norway and the proximity of the site to the water will naturally cool the servers. Kolos will intelligently maximize green energy and the unique geographic features of northern Norway to deliver the most efficient data center services.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"How big will this datacenter be?\"," +
                " 3,\"500,000m²\",\"400,000m²\",\"600,000m²\"," +
                "\"When completed, the site will exceed the Langfang (China) data center in size and capacity, which totals 585,289 m2.\"," +
                "\"Despite this significant and inadequate construction area in this wild environment, Kolos will choose an architecture that blends in with the beauty of the natural landscape and respects the culture and way of life of the community.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"What technologies will be used to supply electricity to the “Kolos” datacenter (which will consume up to 1 gigawatt per year at the end of its construction)?\"," +
                " 1,\"Wind and hydropower\",\"Solar and hydropower\",\"Wind and nuclear power\"," +
                "\"Kolos will be the world's largest green data center, powered by 100% sustainable energy.\"," +
                "\"Kolos will be the largest green data center in the world, powered by 100% sustainable energy from hydropower and wind. As the world leader in renewable energy with an abundance of green energy at 105.5% of its capacity, Norway was the perfect choice for the location of the Kolos data center.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"What is Kolos?\"," +
                " 2,\"A young Swedish-American company\",\"A young American-Norwegian company\",\"A former American company\"," +
                "\"Kolos is an innovative and dynamic young company.\"," +
                "\"Kolos, a young American-Norwegian startup, will build what is billed as the world's largest data center in Ballangen.\");");
        //Fin Datacenter Kolos

        //Cryptomonnaie
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Creating crypto-currencies is synonymous with ecological disaster for some?\"," +
                " 1,\"True\",\"False\",\"Don't know\"," +
                "\"Creating cryptocurrencies requires enormous amounts of electrical energy.\"," +
                "\"Creating cryptocurrencies requires huge amounts of electrical energy, which for some is synonymous with ecological disaster. Cryptocurrency merchants are going to have to buy themselves a good ride and now worry about their carbon footprint.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Bitcoin is based on blocks of encoded and authenticated transactions that are produced by?\"," +
                " 2,\"Storage arrays\",\"Powerful computers\",\"Data centers\"," +
                "\"Transactions are carried out through “miners”.\"," +
                "\"Bitcoin is based on blocks of encoded and authenticated transactions adding to each other. These blocks are generated by powerful computers that help solve equations.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Which of these proposals makes it possible to limit the environmental impact of cryptocurrency mining?\"," +
                " 3,\"The proof of work\",\"Mustard gas\",\"The use of burnt natural gas\"," +
                "\"This gas is also called “flaring”.\"," +
                "\"In the United States, bitcoin generation data centers run on burnt natural gas to limit the environmental impact of the cryptocurrency.\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"The CBECI currently estimates the energy consumption of bitcoin at its all-time high, at 149 TWh which is the equivalent of?\"," +
                " 1,\"~ the total consumption of Egypt.\",\"~ New Zealand's total consumption.\",\"~ the total consumption of Madagascar.\"," +
                "\"The CBECI is the Cambridge Bitcoin Electricity Consumption Index.\"," +
                "\"The Cambridge Bitcoin Electricity Consumption Index currently estimates Bitcoin's energy consumption on an annual basis at an all-time high, at 149 TWh, slightly less than the total electricity consumption of a country like Egypt. .\");");
        db.execSQL("Insert into " + exotypeqcm + " (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Solutions are put in place to reduce the energy consumption of crypto-currencies such as?\"," +
                " 2,\"Use of burnt natural gas and Proof of Work\",\"Use of burnt natural gas and Proof of Stake\",\"Use of burnt natural gas and Proof of Work\"," +
                "\"The second cryptocurrency plans to move from “proof of work” to a system that consumes less energy, which will only allow the use of part of the processors.\"," +
                "\"Some crypto-currencies are considering moving from “proof of work” to a less energy-intensive system. However, it is difficult to see Bitcoin adopt such a change, which risks making the network less decentralized and secure.\");");
        //Fin cryptomonnaie
    }

    public void insertTriAndDecomposition(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"What is the decomposition time of polystyrene?\"," +
                " 1,\"1000 years\",\"Between 250 and 500 years\",\"100 years\"," +
                "\"Polystyrene is one of the longest materials to decompose.\"," +
                "\"Polystyrene takes 1000 years to decompose, it is unfortunately not or very little recycled because it is made up of 98% gas, so only 2% of recoverable materials remain.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Does plastic have a longer decomposition time than polystyrene?\"," +
                " 2,\"True\",\"False\",\"Don't know\"," +
                "\"The decomposition time of a plastic bag is on average 450 years.\"," +
                "\"The plastic bag is a real problem, there are more than 8 billion in nature in the European Union, it is also the main killer of marine animals. There is almost no way to recycle it, which is one of the main reasons the disposable plastic bag was banned for sale.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"How long does it take for a bus or metro ticket to decompose?\"," +
                " 3,\"1 to 2 weeks\",\"1 year\",\"4 to 8 weeks\"," +
                "\"That's longer than you might think!\"," +
                "\"The breakdown time for a metro or bus ticket is 4 to 8 weeks. So be careful, throw your bus and metro tickets in a trash can and not in nature!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"What can be released in the soil and water during the degradation of waste in the wild?\"," +
                " 1,\"Dangerous molecules\",\"Dangerous bacteria\",\"Viruses\"," +
                "\"a single butt can resist 1 to 5 years in nature. Throwing it into a river could pollute up to 500 liters of water!\"," +
                "\"In addition to the visual pollution that waste represents. It’s a real danger to the environment. Natural degradation can take an extremely long time. Also, the waste can depose dangerous molecules both for humans and for nature into the soil and water.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"A liter of used motor oil with a decomposition time of 5 to 10 years could cover an area of?\"," +
                " 2,\"100 m²\",\"1000 m²\",\"10000 m²\"," +
                "\"A single liter of waste oil emptied in the countryside can prevent the oxygenation of the water and disturb the flora and fauna for several years.\"," +
                "\"A single liter of used oil decomposes completely between 5 and 10 years, can cover an area of ​​1000 m², and consequently prevent the oxygenation of the water and disturb the flora and fauna for several years.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"In France, waste collection and treatment are organized into three channels, which ones?\"," +
                " 3,\"Recycling, decomposition, incineration\",\"Recycling, composting, biomass\",\"Recycling, composting, incineration\"," +
                "\"Recycling and composting are two important channels in the collection and treatment of waste.\"," +
                "\"Fortunately, the collection and treatment of waste are well organized in most countries. The lines of waste treatment in France are recycling, composting, and incineration. These lines make it possible to accelerate the degradation of waste and especially to avoid finding it in the middle of nature!\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"How do we know that glass can withstand over 4000 years in nature?\"," +
                " 1,\"Egyptian archaeological discoveries\",\"Fossil discoveries\",\"African archaeological discoveries\"," +
                "\"Glass can withstand more than 4000 years, as some archaeological finds prove.\"," +
                "\"We know that glass can withstand more than 4,000 years in nature thanks to Egyptian archaeological discoveries.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"How many tons of plastic waste are floating in our oceans?\"," +
                " 2,\"1,000,000 tons\",\"300,000 tons\",\"300 tons\"," +
                "\"There are over 300 tons of garbage floating around in our oceans.\"," +
                "\"Almost 300,000 tons of plastic waste is believed to be floating in our oceans. These residues resist for hundreds of years and thus endanger ecosystems.\");");

        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"At the sorting centre, the packaging is?\"," +
                " 2,\"Separated according to their colour\",\"Separated manually and with machines by material family\",\"Burned upon arrival\"," +
                "\"Warning trap question: Packaging has no colors!\"," +
                "\"Packaging is separated manually and with machines by metal family. @clubciteo.com\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Is recycling the best solution?\"," +
                " 2,\"True\",\"False\",\"Have no idea\"," +
                "\"Recycling is not yet optimal.\"," +
                "\"Many products that we think are almost infinitely recyclable are not. Less than 20% of our products that we think are recyclable will actually be recycled. Warning: recyclable products are better than non-recyclable ones. More information on www.edeni.fr/comprendre-le-recyclage/pourquoi-il-ne-faut-pas-recycler/\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"What does the recycler buy?\"," +
                " 1,\"He buys bales of packaging and paper sorted\",\"He buys piles of packaging\",\"He buys unsorted packaging\"," +
                "\"Waste must be sorted.\"," +
                "\"That was the first answer. @clubciteo.com\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"What method should be used before recycling?\"," +
                " 3,\"Recycle-Reuse-Reduce-Decline\",\"Reuse-Decline-Reduce-Recycle\",\"Refuse-Reduce-Reuse-Recycle\"," +
                "\"The recycling process has to come towards the end.\"," +
                "\"Refuse what is not needed (commercial ads, single use packaging), Reduce what we need (avoid overconsumption), Reuse/repair what we already have\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Who is the first link in the sorting chain?\"," +
                " 2,\"One operator in the center of the sort\",\"You, by sorting your packages\",\"The ripper that picks up the sorting bins\"," +
                "\"It's just after the utilisation of the product.\"," +
                "\"You are the first link in the sorting chain. @clubciteo.com\");");

    }

    public void insertClimateChange(SupportSQLiteDatabase db) {
        //GulfStream niveau1
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What is the Gulf Stream? An oceanic stream taking its source:\"," +
                " 1,\"Between Florida and the Bahamas\",\"Between Malaysia and Indonesia\",\"Between Greenland and Iceland\"," +
                "\"The Gulf Stream is an oceanic stream which originates in warm waters.\"," +
                "\"The Gulf Stream is an ocean stream which originates between Florida and the Bahamas and dilutes in theAtlantic Ocean towards the longitude of Greenland. The Gulf Stream plays a role in the North Atlantic Drift which designates the slow movement of the warm waters of the Atlantic thanks to the Gulf Stream towards the northeast (Western Europe) and the Arctic Ocean.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Is it that global warming could speed up the Gulf Stream?\"," +
                " 2,\"True\",\"False\",\"Don't know\"," +
                "\"The Gulf Stream is affected by global warming.\"," +
                "\"The IPCC researchers hypothesized that global warming could cause the stop of the thermohaline circulation, due to the decrease in salinity and the increase in temperature of the Arctic Ocean. The thermohaline circulation participates in the redistribution of heat in the world. Scientists observe that the Gulf Stream is slowing down due to climate change. Thus, it thus reaches its lowest level for a millennium.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What is thermohaline circulation? Ocean circulation caused by:\"," +
                " 3,\"Differences in air temperatures\",\"Differences in salinity in water\",\"Differences in seawater density\"," +
                "\"In thermohaline, the term thermo means temperature and halin means salinity.\"," +
                "\"The thermohaline circulation is the oceanic circulation caused by differences in the density of seawater. These differences in density arise from the differences in temperature and salinity of water masses, hence the terms thermo for temperature and halin for salinity. .\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What could happen if the Gulf Stream were to stop?\"," +
                " 1,\"Freezing climate in Europe\",\"Saharan climate in Europe\",\"Saharan climate in North America\"," +
                "\"The stopping of the Gulf Stream could lead to the depopulation of Europe.\"," +
                "\"The Gulf Stream is partly responsible for the temperate climate we experience in western northern Europe. However, this circulation could well run out of steam and generate an icy climate in Europe. The Gulf Stream warms Western Europe, and therefore promotes agriculture. A collapse of agriculture would lead to the depopulation of Europe.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What is one of the elements which strongly disturbs the Gulf Stream among these proposals?\"," +
                " 2,\"Global warming\",\"Melting glaciers in Greenland\",\"Overpopulation\"," +
                "\"Global warming results in melting glaciers and does not directly disturb the Gulf Stream.\"," +
                "\"Due to the combined impact of the melting Greenland and increased precipitation, the Gulf Stream could therefore weaken and reverse in the years to come.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Is-that the Gulf Stream is about to shift over to the north?\"," +
                " 1,\"True\",\"False\",\"Don't know\"," +
                "\"The shifting Gulf Stream is bringing warmer temperatures off the North American coast.\"," +
                "\"According to two studies published in “Nature”, the Gulf Stream is slowing down and is shifting northwards, resulting in warmer temperatures off the North American coast and colder south of Greenland.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What does AMOC mean?\"," +
                " 2,\"The Atlantic overturning sea current\",\"The Atlantic meridional overturning circulation\",\"The meridional overturning circulation\"," +
                "\"In French, AMOC means: La circulation méridienne de retournement Atlantique.\"," +
                "\"The Atlantic Meridional Overturning Circulation (AMOC) is a large system of ocean currents that carry warm water from the tropics north into the North Atlantic. The Gulf Stream is only the surface part of the AMOC in the North Atlantic.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"In the film “The day after tomorrow”, a new ice age takes place caused by the acceleration of the Gulf Stream?\"," +
                " 3,\"True\",\"Don't know\",\"False\"," +
                "\"The probability of a temporary shutdown of the Gulf Stream in the next 100 years would be around 15%\"," +
                "\"There is a growing risk of claiming that AMOC may shut down at a given moment, making the film “The day after tomorrow” a reality. In this film, the AMOC stopped, initiating a new ice age. Watch out little trap ^ _ ^.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"In which year did Europe experience the Little Ice Age?\"," +
                " 1,\"Between 1450 and 1850\",\"In the 21st century\",\"In the 15th century\"," +
                "\"Europe experienced 11 of its 12 warmest years in the 21st century.\"," +
                "\"In history, 13,000 years ago, AMOC had weakened, resulting in a drop in temperatures of 6 ° C in Greenland. Another slowdown in the Gulf Stream is partly at the origin of the Little Ice Age that Europe experienced between 1450 and 1850.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"What is the percentage of chances / risks that the Gulf Stream will stop in the Next 100 years?\"," +
                " 2,\"50%\",\"15%\",\"90%\"," +
                "\"This percentage was obtained thanks to a simulation and this stop would only be temporary.\"," +
                "\"According to a new simulation, the North Atlantic Current which allows a relatively mild climate in Europe would have a 15% risk of stopping over the next 100 years but this stopping would only be temporary.\");");

        //Canada & Artique
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"The Arctic is an area little affected by anthropogenic global warming compared to other places on Earth?\"," +
                " 1,\"False\",\"True\",\"Don't know\"," +
                "\"Melting ice is particularly prevalent in the Arctic.\"," +
                "\"The Arctic is the place most severely affected by anthropogenic global warming than anywhere else on Earth. The Canadian authorities have decided to classify an area with the thickest ice as a “marine protected area” in order to serve as a refuge for animals.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"What does the term “anthropogenic” mean in “anthropogenic global warming”?\"," +
                " 2,\"Of animal origin.\",\"Of human origin.\",\"Of distant origin.\"," +
                "\"Anthropology is a science that studies humans and groups of humans in all their aspects, both physical and cultural.\"," +
                "\"The causes of anthropogenic pollution are for example: domestic activities such as heating, industrial activities, road or non-road transport, agriculture, etc.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Researchers are studying regions of the Arctic where animals living on the ice could take refuge there, what is the name of this area?\"," +
                " 3,\"Toong-a-su-git\",\"Alianaigusukpunga takujunnarakkit!\",\"Tuvaijuittuq\"," +
                "\"The translation of this region in Inuktitut is: “the place where the ice never melts”.\"," +
                "\"Scientists estimate this is where the oldest and thickest pack ice is in the Arctic Ocean.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Parts of the “last ice patch” have already started to decline, on August 14, 2020 satellite images showed a record thinning of ice thickness of?\"," +
                " 1,\"50%\",\"70%\",\"20%\"," +
                "\"The sea ice thickness at the start of the summer was near normal.\"," +
                "\"On August 16, 2020, Polarstern, a German icebreaker, was in the last ice area for the Mosaic expedition. Two days earlier, the measured ice concentration was only 50% of that usual.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Is global warming the only one called into question in the reduction of ice zones in the Arctic?\"," +
                " 2,\"Yes, it melts the ice.\",\"No, unusual winds can add to the warming of temperatures.\",\"Yes, because it causes climate change.\"," +
                "\"According to researchers, only 20% of the observed thinning of sea ice is due to global warming.\"," +
                "\"Using satellite data and models. The researchers concluded that 80% of the observed thinning was due to weather factors. For example, unusual winds that moved sea ice out of the area. But the remaining 20% ​​of the thinning of the sea ice is indeed due to global warming.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"On June 29, 2021, Portland International Airport in the Northwest of the United States recorded a new temperature record of?\"," +
                " 1,\"116 ° F (46.7 ° C)\",\"121 ° F (49.6 ° C)\",\"98 ° F (36.7 ° C)\"," +
                "\"49.6 ° C were recorded in Lytton (Canada) during this same period.\"," +
                "\"On June 23, 2021,agencies meteorological announced a heat wave historic and dangerous. In Portland as in Lytton, the normal for June is around 20 ° C! Experts did not hesitate to speak of the wave of heat more extreme than the Earth has known for a long time.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"What is a heat dome?\"," +
                " 2,\"Hot air is trapped by low pressures, and as it is pushed back to the ground, heats up further\",\"Hot air is trapped by high pressures, and as it is pushed back to the ground, heats up further.\",\"Hot air is trapped by high pressures, and as it is pushed upwards, heats up further\"," +
                "\"This phenomenon can be compared to if you compress air in a bicycle tire, it heats it up.\"," +
                "\"The phenomenon in play is called heat dome. The hot air is trapped by strong pressures, and being pushed back to the ground, heats up further.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"June 30, 2021, 49.6 ° C (121 ° F) in Lytton, Canada, has it never been so hot above 50 ° north latitude?\"," +
                " 3,\"False\",\"Don't know\",\"True\"," +
                "\"It's hotter than the highest temperature ever recorded in Europe or even South America.\"," +
                "\"It's hotter than the highest temperature ever recorded in Europe or even South America. a staggering temperature of 49.6 ° C was recorded. A record for a city located beyond 50 ° north latitude.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Global warming is the main cause of this strong heat wave, does it make heat waves?\"," +
                " 1,\"more frequent, longer, more intense\",\"more frequent, shorter, more intense\",\"less frequent, longer, more intense\"," +
                "\"Global warming is making the climate unstable with more and more frequent heat waves.\"," +
                "\"According to the researchers, the question no longer arises. The global warming makes heat waves more frequent, longer and more intense.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"How many times do heat waves occur more often than in the 1960s?\"," +
                " 2,\"Five times more often\",\"Three times more often\",\"Ten times more often\"," +
                "\"Heat waves occur at least three times more often than in the 1960s.\"," +
                "\"Scientists have long predicted this. Heat waves are now three times more frequent than they were in the 1960s. They affect 25% more land in the northern hemisphere than in 1980. In the northwestern region of Pacific affected at the end of June 2021, researchers announce a stress heat that will triple by 2100.\");");

        //Amazon rainforest & weather forecast
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"What are the elements that have contributed to the reduction in the capacity to eliminate carbon dioxide in the Amazon rainforest?\"," +
                " 1,\"Deforestation, fires and rapid local warming\",\"Deforestation, fires and global warming\",\"Deforestation and fires\"," +
                "\"Temperatures during the dry season have gained nearly 3 ° C compared to the pre-industrial era.\"," +
                "\"Due to climate change and deforestation, a large part of the Amazon basin now emits more CO2 than it absorbs, a major transformation for this crucial ecosystem in limiting the Warming.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"What part of the Amazon rainforest is no longer a terrestrial carbon sink?\"," +
                " 2,\"North-West\",\"South-East\",\"North\"," +
                "\"Part of the Amazon has gone clearly from a carbon sink to a CO2 source.\"," +
                "\"The Brazilian research team collected 600 samples of CO2 and carbon monoxide from 2010 to 2018. According to their findings, the northwestern part of the Amazon is in equilibrium, absorbing as much CO2  as it emits. But the east (South-East), especially in the dry season, is an obvious source.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Climate Change is a key factor in the ability to absorb CO2, temperatures during season dry have gained nearly X ° C compared to the pre-industrial era?\"," +
                " 3,\"5 ° C\",\"1.5 ° C\",\"3 ° C\"," +
                "\"+ 1.5 ° C is the goal not to be exceeded for 2050 on global warming.\"," +
                "\"Among the causes of this degradation, the forests burnt to make way for livestock and agriculture. Climate change is also a major factor: temperatures during the dry season have risen by almost 3 ° C compared to pre-industrial times, almost three times the global average.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"The decline of the Amazon rainforest is one of the tipping points with?\"," +
                " 1,\"melting ice caps, thawing permafrost, disappearance of coral reefs…\",\"melting ice, disappearing coral reefs…\",\"melting ice caps, disappearing coral reefs…\"," +
                "\"These tipping points could lead the climate system towards a dramatic and irremediable change.\"," +
                "\"With the  melting ice caps, the thaw of the permafrost, the disappearance of coral reefs and the decline of the Amazon rainforest. These elements are part of the Tipping points identified by scientists whose substantial modification could lead the climate system to a dramatic and irremediable change.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Among the quizzes available on Environment Quiz, which quiz talks about permafrost?\"," +
                " 2,\"Data Centers\",\"Svalbard Seed Vault\",\"Dive into The Ocean: Raja Ampat\"," +
                "\"Raja Ampat is an archipelago located in Indonesia.\"," +
                "\"The quiz available on permafrost is the quiz: “Svalbard Seed Vault”. It is available in the quizzes of the week and under the section: “👩‍🌾 culture 🌱”.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"The weather forecast involves many factors such as?\"," +
                " 1,\"Analysis of winds, atmospheric pressure, temperatures, etc.\",\"Analysis of winds and temperatures\",\"Analysis of the composition of air and winds\"," +
                "\"Weather forecasts rely on many factors.\"," +
                "\"Weather forecasts rely on many factors: analysis of winds, atmospheric pressure, temperatures, ...\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"How many week (s) in advance can a heat wave period be predicted?\"," +
                " 2,\"Three weeks\",\"One week\",\"Five weeks\"," +
                "\"We can tell several months in advance whether a season will be hot or cold.\"," +
                "\"The forecast of the trajectory of a tornado is limited to about ten minutes. While for a storm is about 3 days in advance, a period of dog days a week and several months we can say in advance whether a season will be rather hot or cold\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"The way to forecast long-term weather improves, can it be said that the reliability of the forecast improves by?\"," +
                " 3,\"Five days every 10 years\",\"Three days every 10 years\",\"One day every 10 years\"," +
                "\"The reliability of the four-day forecast today is equivalent to that of three days 10 years ago.\"," +
                "\"We have averaged one forecast day every 10 years for the past 30 years. This means that the reliability of the four-day forecast today is equivalent to that of three days 10 years ago and two days 20 years ago.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"What is the butterfly effect in meteorology?\"," +
                " 1,\"A tiny change can make a huge difference\",\"A huge difference can cause a tiny change\",\"Clouds are rising in the sky\"," +
                "\"It is very important to consider in the process of calculating the forecast.\"," +
                "\"The Butterfly effect at the base means that a tiny change in conditions at the start can make a huge difference in the end. It is somewhat the same principle in meteorology when the process of calculating forecasts takes place.\");");
        db.execSQL("Insert into exotypeqcmen (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"What is the troposphere?\"," +
                " 2,\"The upper layer of the atmosphere\",\"The lower layer of the atmosphere\",\"The tropical air layer\"," +
                "\"It is present on planets like the Earth, Mars or Venus\"," +
                "\"The troposphere is the lower layer of the atmosphere. It is present on planets like the Earth, Mars or Venus. In this area, gases are held close to the earth's ground by gravity. The troposphere contains clouds and most of the water vapor in the atmosphere. It is the seat of meteorological events (clouds, thunderstorms, etc).\");");

    }
}
