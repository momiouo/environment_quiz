package com.momiouo.naturequiz.data.datasource.db;

import androidx.sqlite.db.SupportSQLiteDatabase;

public class DBContent {

    public void insertTopNews(SupportSQLiteDatabase db){
        //---------------------------------Les Top news
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Quel est le nom du mouvement qui a pour but de collecter le plastique dans les océans ?\"," +
                " 1,\"The ocean cleanup\",\"Clean the pacific\",\"Ocean cleaner\"," +
                "\"C’est une organisation non gouvernementale qui développe une technologie pour extraire la pollution plastique des océans.\"," +
                "\"L'organisation mène des recherches scientifiques sur la pollution plastique océanique. Ils ont mené deux expéditions dans le Gyre subtropical du Pacifique nord et publié des articles scientifiques. Ils prévoient que cette capacité pourrait nettoyer 50% des débris dans le Vortex de déchets du Pacifique nord en cinq ans.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Quelle est le nom du fondateur d’ocean cleanup ?\"," +
                " 1,\"Boyan Slat\",\"Jeff Bezos\",\"Donald Duck\"," +
                "\"Il est d’origine croate.\"," +
                "\"L’organisation a été fondé en 2013 par Boyan Slat, un inventeur-entrepreneur néerlandais d'origine croate qui en est le PDG.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Combien d’arbres ont été plantés grâce au moteur de recherche Ecosia en dix ans ?\"," +
                " 3,\"100 milles\",\"50 milliards\",\"100 millions\"," +
                "\"En janvier 2018, le nombre d'arbres plantés par Ecosia a dépassé les 20 millions.\"," +
                "\"Pendant onze ans, le moteur de recherche Ecosia a utilisé la plupart de ses revenus dans la publicité sur son site Web et son application pour planter des arbres. Et ce mois-ci (Juillet 2020), ils ont planté leur 100 millionième arbre.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Parmis ces espèces, laquelle est sorti du statut “en danger d’extinction” ?\"," +
                " 2,\"Le grand requin\",\"La baleine grise\",\"Le gorille\"," +
                "\"Cette espèce vit dans l’eau.\"," +
                "\"Quasiment éteinte au début du 20ème siècle, la baleine grise était devenue une espèce protégée en 2017. Complètement disparue de l’océan Atlantique à cause de la pêche intensive, une population d’environ 20 000 individus existe encore dans l’océan Pacifique. Du statut “en danger d’extinction”, elle est ainsi passée à celui de “préoccupation mineure”. Un exploit.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Quel est la hausse de la population du panda géant en 10 ans ?\"," +
                " 1,\"17% de sa population\",\"34% de sa population\",\"5% de sa population\"," +
                "\"Dans les années 1980, il n'y avait que 1 114 pandas en Chine. Mais le dernier recensement réalisé en 2013 révèle qu'il y aurait désormais 1 864 pandas vivant à l'état sauvage.\"," +
                "\"Dans les années 1980, ils ne restaient plus que 1 114 pandas à l’état sauvage en Chine. Dans les années 2000, ils étaient 1 600 environ. Aujourd’hui, ils sont 1 864 dans le monde grâce aux efforts de conservation déployés sur son aire de répartition ! Toutefois, il reste encore beaucoup à faire pour mettre définitivement le panda à l’abri de toute menace car sa population reste faible.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Est-il vrai que les agriculteurs utilisent des suppléments d’oignon pour lutter contre les gazs des vaches ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"Les vaches produisent du méthane, un composé chimique mauvais pour l’environnement !\"," +
                "\"Un nouveau complément alimentaire à base d'ail administré aux vaches a été démontré dans deux études différentes pour réduire la teneur en méthane des crottes des vaches de 30% à 38%, ce qui pourrait aider à réduire jusqu'à 2,6% du volume de gaz à effet de serre américain produit par l'élevage bovin.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"Quel est le pourcentage d'américain qui admettent avoir fait au moins un changement positif pour l'environnement en 2018 ?\"," +
                " 2,\"50%\",\"85%\",\"20%\"," +
                "\"Quatre personnes sur dix ont déclaré avoir pris une décision, soucieux de l'environnement au moins une fois par semaine, et près d'un sur trois ont déclaré le faire quotidiennement.\"," +
                "\"Dans le but d'être plus respectueux de l'environnement, 85% des Américains interrogés ont apporté au moins un changement positif à leur mode de vie au cours de la dernière année. La bonne nouvelle est qu'un intérêt croissant pour devenir plus respectueux de l'environnement est un mouvement contagieux : la moitié des personnes interrogées ont déclaré avoir incité quelqu'un d'autre à être plus respectueux de l'environnement.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",1," +
                "\"La terre est-elle de plus en plus verte ?\"," +
                " 1,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"La Terre est surnommé la planète Bleu.\"," +
                "\"Selon une étude de la Nasa publiée dans la revue Nature en février 2020, la planète s'est végétalisée depuis ces dernières années. Les experts constatent que la Terre a gagné 5 % de surface verte entre 2000 et 2017, soit l'équivalent de la forêt amazonienne. On doit cette progression principalement à la Chine et l'Inde, avec une reforestation massive dans le pays pour le premier et le développement des terres cultivées pour le second.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Lors de ces dernières années combien de pays ont réduit leurs émissions de CO2 ?\"," +
                " 3,\"7\",\"13\",\"18\"," +
                "\"Les pays développés ont réduit leurs émissions de CO2 grâce à l’utilisation des énergies renouvelables.\"," +
                "\"18 pays développés ont réduit leurs émissions de CO2 sur la période 2005-2015, parmi lesquels la France, le Royaume-Uni, la Belgique, l'Italie ou encore les Etats-Unis. Tandis qu'en 2018, le niveau mondial des émissions a augmenté de 2 %, concernant ces 18 pays, il a baissé de 2,4 % par an sur cette période. Un chiffre qui s'explique notamment par l'abandon des énergies fossiles au profit des énergies renouvelables.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quel est l’autonomie annuelle en énergie et en eau des deux bâtiments autonomes de Grenoble ?\"," +
                " 3,\"70%\",\"90%\",\"60%\"," +
                "\"Le bâtiment concerné utilisera trois fois moins d’eau et d'énergie en provenance des réseaux urbains qu’un logement normal.\"," +
                "\"C’est dans l’Ecocité Presqu’Île à Grenoble que s’élève le premier démonstrateur ABC de France. Ce concept, dont l’acronyme signifie « Autonomous Building for Citizens » est le résultat d’un projet de recherche et de développement mené par Bouygues Construction et développé par Linkcity Sud-Est. Un véritable concentré de technologies visant un bilan énergétique nul et une autonomie annuelle en énergie et en eau de 70%.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"De combien de tonnes de gaz à effet de serre le coronavirus a permis d'éviter en chine ?\"," +
                " 1,\"200 millions\",\"800 milles\",\"50 millions\"," +
                "\"L’an passé, la Chine avait émis 800 millions de tonnes de CO2 sur cette même période (après les congés du Nouvel An).\"," +
                "\"L’épidémie de coronavirus en ralentissant l’économie a fait chuter la pollution de l’air en Chine. L’épidémie de coronavirus aurait fait chuter de 25 % les émissions chinoises de CO2 sur ces quatre dernières semaines (représentant environ 200 millions de tonnes de gaz à effet de serre).\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"De quelle nationalité est Greta Thunberg ?\"," +
                " 2,\"Norvégienne\",\"Suédoise\",\"Russe\"," +
                "\"Elle est originaire d’un pays scandinave.\"," +
                "\"Greta Thunberg, née le 3 janvier 2003 à Stockholm, est une militante écologiste suédoise engagée dans la lutte contre le réchauffement climatique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"A quelle date l’aéroport de San Francisco a arrêté la vente de bouteille d’eau en plastique ?\"," +
                " 1,\"20 août 2020\",\"1 août 2020\",\"22 janvier 2021\"," +
                "\"Un programme lancé en 2016 prévoit de passer à “zéro déchet” pour 2021\"," +
                "\"Près de 100 fontaines ont déjà été installées dans l'aéroport, afin de permettre aux voyageurs de remplir leur bouteille d'eau et les encourager à ne pas acheter une autre bouteille (4 millions de bouteilles d’eau sont vendues chaque année). À compter du 20 août 2020, les magasins et restaurants ne seront plus autorisés à vendre des bouteilles en plastique, l'eau est disponible dans des bouteilles en verre, en matériaux compostables certifiés, ou en aluminium recyclé.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"A quelle date McDonald’s France a supprimé l’utilisation des pailles en plastiques ?\"," +
                " 2,\"Septembre 2018\",\"Novembre 2019\",\"Janvier 2020\"," +
                "\"La France se prépare à la disparition totale des pailles en plastique dès 2021.\"," +
                "\"McDonald's France a lancé dès novembre 2019, au niveau national, une solution alternative, sans pailles. il s'agit d'un couvercle moulé en fibres de papier, recyclable, avec un petit bec à boire. Il permettra une économie annuelle de 1 200 tonnes de plastique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quel est le prix à l’unité des pailles en verres de Dior ?\"," +
                " 3,\"40 €\",\"5 €\",\"22 €\"," +
                "\"Les pailles sont en verre soufflé et peintes à la main.\"," +
                "\"La marque française a élaboré un coffret de six pailles en verre soufflé et peintes à la main. Les objets sont ornés de doré et sont vendus dans une élégante boîte blanche et rouge. Une paille design et de grand couturier qui a un prix : 130 euros la boîte de six pailles soit 22 euros la paille !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quel est le nom du premier magasin bio en France ?\"," +
                " 2,\"L’Eau Vive\",\"La Vie Claire\",\"Naturalia\"," +
                "\"En 1980, l'entreprise est reprise par le Groupe Bernard Tapie qui rénove le réseau et tente de rajeunir l’image de marque, notamment en sponsorisant une équipe cycliste dédiée à Bernard Hinault.\"," +
                "\"En 1948, alors que le label AB n'existait pas encore, la Vie Claire lance un premier magasin bio en France, avec comme slogan : La bio est dans ma nature. Aujourd'hui, elle est la deuxième enseigne spécialisée et compte plus de 360 magasins.\");");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quelle ville en France va accueillir une forêt urbaine ?\"," +
                " 3,\"Strasbourg\",\"Annecy\",\"Lyon\"," +
                "\"Elle fait partie de la région Auvergne Rhône-Alpes.\"," +
                "\"La ville de Lyon a décidé de planter 4500 à 6000 arbres dans son 9ème arrondissement. Cette forêt devrait commencer à voir le jour au début de l’automne prochain. A l’origine de l’initiative : La SACVL (Société anonyme de construction), un opérateur immobilier, qui espère ainsi compenser l’empreinte carbone des 200 logements qu’elle construit chaque année.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quelle ville est la capitale verte Européenne 2022 ?\"," +
                " 1,\"Grenoble\",\"Turin\",\"Tallinn\"," +
                "\"Avec son agglomération de 670 000 habitants, elle est également la plus grande métropole des Alpes, devant Innsbruck dont l'agglomération ne compte que 300 000 habitants, et Bolzano.\"," +
                "\"Grenoble a été désignée comme lauréate du titre de capitale Verte Européenne 2022. Le Jury qui s’est déroulé le 8 octobre a départagé qui de Grenoble, Turin, Dijon ou Tallin serait l'ambassadrice des transitions en 2022.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Chaque année, la forêt absorbe combien d’émissions de carbone à l’échelle mondiale ?\"," +
                " 2,\"Entre 5% et 8%\",\"Entre 10% et 15%\",\"Entre 35% et 45%\"," +
                "\"La déforestation et la dégradation des forêts sont responsables de 11% des émissions mondiales de gaz à effet de serre.\"," +
                "\"La forêt constitue un véritable puits de carbone puisqu’elle permet le stockage du CO2 atmosphérique. Chaque année, elle absorbe entre 10 et 15 % des émissions de carbone à l’échelle mondiale. Les arbres peuvent atténuer les effets du changement climatique en jouant un rôle à plusieurs niveaux : 1 mètre cube de bois de chêne absorbe une tonne de CO2. La forêt joue un rôle primordial dans l’atténuation et la lutte contre le changement climatique.\");");
    }

    public void insertNewTopNewsV2V3(SupportSQLiteDatabase db){

        db.execSQL("UPDATE exotypeqcm set question = \"A quelle date l’aéroport de San Francisco a arrêté la vente de bouteille d’eau en plastique ?\" " +
                ", explication = \"Près de 100 fontaines ont déjà été installées dans l'aéroport, afin de permettre aux voyageurs de remplir leur bouteille d'eau et les encourager à ne pas acheter une autre bouteille (4 millions de bouteilles d’eau sont vendues chaque année). À compter du 20 août 2020, les magasins et restaurants ne seront plus autorisés à vendre des bouteilles en plastique, l'eau est disponible dans des bouteilles en verre, en matériaux compostables certifiés, ou en aluminium recyclé.\"  " +
                "where question LIKE \"A quelle date l’aéroport de San Francisco envisage d'arrêter la vente de bouteille d’eau en plastique ?\" ");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quelle ville en France va accueillir une forêt urbaine ?\"," +
                " 3,\"Strasbourg\",\"Annecy\",\"Lyon\"," +
                "\"Elle fait partie de la région Auvergne Rhône-Alpes.\"," +
                "\"La ville de Lyon a décidé de planter 4500 à 6000 arbres dans son 9ème arrondissement. Cette forêt devrait commencer à voir le jour au début de l’automne prochain. A l’origine de l’initiative : La SACVL (Société anonyme de construction), un opérateur immobilier, qui espère ainsi compenser l’empreinte carbone des 200 logements qu’elle construit chaque année.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Quelle ville est la capitale verte Européenne 2022 ?\"," +
                " 1,\"Grenoble\",\"Turin\",\"Tallinn\"," +
                "\"Avec son agglomération de 670 000 habitants, elle est également la plus grande métropole des Alpes, devant Innsbruck dont l'agglomération ne compte que 300 000 habitants, et Bolzano.\"," +
                "\"Grenoble a été désignée comme lauréate du titre de capitale Verte Européenne 2022. Le Jury qui s’est déroulé le 8 octobre a départagé qui de Grenoble, Turin, Dijon ou Tallin serait l'ambassadrice des transitions en 2022.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",2," +
                "\"Chaque année, la forêt absorbe combien d’émissions de carbone à l’échelle mondiale ?\"," +
                " 2,\"Entre 5% et 8%\",\"Entre 10% et 15%\",\"Entre 35% et 45%\"," +
                "\"La déforestation et la dégradation des forêts sont responsables de 11% des émissions mondiales de gaz à effet de serre.\"," +
                "\"La forêt constitue un véritable puits de carbone puisqu’elle permet le stockage du CO2 atmosphérique. Chaque année, elle absorbe entre 10 et 15 % des émissions de carbone à l’échelle mondiale. Les arbres peuvent atténuer les effets du changement climatique en jouant un rôle à plusieurs niveaux : 1 mètre cube de bois de chêne absorbe une tonne de CO2. La forêt joue un rôle primordial dans l’atténuation et la lutte contre le changement climatique.\");");

    }

    public void insertDechetsEtDecompo(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Decomposition\",1," +
                "\"En combien temps se décompose un ticket de bus jeté par terre ?\"," +
                " 2,\"4 mois\",\"1 an\",\"3 ans\"," +
                "\"Ne jetez pas vos ticket de bus par terre !\"," +
                "\"Les tickets de bus font parties des déchets se dégradant en un peu plus d’un 1 an avec les gants, les chaussettes en laine, les mégots de cigarette …\");");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Decomposition\",1," +
                "\"Parmis ces déchets lequel prend le plus de temps pour se dégrader ?\"," +
                " 3,\"Mouchoir en papier\",\"Chewing-gum\",\"Canette en acier\"," +
                "\"Il ne faut pas jeter par terre les mouchoirs en papier par terre mais ça reste le moins pire.\"," +
                "\"Le chewing fait partie des déchets se dégradant entre 1 à 10 ans alors que la canette en acier elle prend environ 100 ans afin de se dégrader.\");");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesdechets\",1," +
                "\"Est ce qu’un français génère plus de déchets ménagers par an qu’un habitant européen ?\"," +
                " 1,\"Oui\",\"Non\",\"peut-être\"," +
                "\"Les déchets ménagers par habitant représentent 513 kg en France.\"," +
                "\"Un Européen génère 487 kg de déchets ménagers chaque année. Depuis 2014 les ordures ménagères par habitant augmentent : il est le plus élevé au Danemark (781 kg), Chypre (637 kg) et en Allemagne (633 kg). ... Les déchets ménagers par habitant représentent 513 kg en France en 2017.\");");
    }

    public void insertAnimaux(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Quel est le nombre de nouvelles espèces découvertes dans le monde chaque jour ?\"," +
                " 2,\"15\",\"50\",\"150\"," +
                "\"Environ 18000 nouvelles espèces sont découvertes chaque année.\"," +
                "\"On découvre près de 50 nouvelles espèces par jour en moyenne. Des découvertes qui ne compensent pourtant pas la disparition complète d'autres espèces de plantes ou d'animaux.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Combien de tortues sont nées pendant le confinement en 2020 sur la côte de Paulista au Brésil ?\"," +
                " 2,\"52\",\"97\",\"74\"," +
                "\"Alors que près d’un milliard de personnes étaient confinées dans le monde, les animaux ont pu bénéficier de ce répit. 291 tortues sont nées la côte de Paulista en 2020\"," +
                "\"Épargnées par les promeneurs, d’habitude nombreux, 97 œufs ont éclos. L’espèce ne se reproduit que tous les deux ou trois ans dans une quarantaine de pays et territoires de la région des Caraïbes ainsi qu'au Brésil\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Combien reste-t-il d’éléphants d’Afrique à l’état sauvage ?\"," +
                " 1,\"415 000\",\"200 000\",\"20 000\"," +
                "\"Les défenses des éléphants attirent la convoitise des braconniers causant la mort de 20 000 à 30 000 éléphants chaque année.\"," +
                "\"Les populations d’éléphants ont chuté entre le 19ème et 20ème siècles. L’espèce compte aujourd’hui environ 415 000 individus contre 3 à 5 millions au début du 20ème siècle\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Combien de fleurs peut polliniser une colonie d’abeilles par jour ?\"," +
                " 3,\"10 milles\",\"200 milliards\",\"300 millions\"," +
                "\"Une cuillère à café de miel représente 499 voyages pour récolter le nectar, 49 900 fleurs visitées et 760 km parcourus par une abeille mellifère.\"," +
                "\"Une colonie peut polliniser 300 millions de fleurs par jour & aide 90% des plantes sauvages à prospérer.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Quelle est l’espèce la plus menacée ?\"," +
                " 1,\"Le Grand Requin\",\"L’Elephant d’Asie\",\"Le Tigre du Bengale\"," +
                "\"Il appartient à l'ordre des lamniformes, c’est un redoutable prédateur.\"," +
                "\"Depuis 15 ans, la population des grands requins blancs a diminué de presque 80%. Chaque année, plus de 100 millions de requins sont tués.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Combien y-a-t-il d’espèces de poissons dans la grande barrière de Corail ?\"," +
                " 1,\"1625\",\"54\",\"723\"," +
                "\"La barrière de corail recouvre près de 133 espèces de requins et de raies.\"," +
                "\"La grande barrière de corail est la plus vaste structure vivante du monde ! Elle regroupe 1625 espèces de poissons, 600 espèces de coraux et 133 espèces de requins et de raies sur plus de 3000 récifs et 600 îles.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Quelle est la longueur de la grande barrière de Corail en Australie ?\"," +
                " 2,\"1000 mètres\",\"2300 km\",\"5000 km\"," +
                "\"La grande barrière de corail est visible depuis l’espace, c’est la plus vaste structure vivante du monde.\"," +
                "\"La grande barrière de corail mérite bien son nom. Avec ses 3000 récifs qui s’étirent sur près de 2300 km le long de la côte est de l’Australie. Elle recouvre 344 000 km² (quasiment la surface de l’Allemagne).\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"D’ou provient le nectar ?\"," +
                " 1,\"La fleur\",\"La ruche\",\"L’’abeille\"," +
                "\"Les abeilles récupèrent le nectar dans la nature.\"," +
                "\"les plantes sécrètent du nectar. Ce liquide sucré est ensuite récupéré par l'abeille. Une fois de retour à la ruche, l'abeille régurgite le nectar. Celui-ci est de nouveau ingurgité par d'autres abeilles avant d'être déposé dans des alvéoles en cire.Le travail se termine grâce aux abeilles ventileuses qui vont encore assécher la préparation. Lorsque la teneur en eau du nectar tombe en dessous de 20 %, l'insecte scelle l'alvéole et le miel est ainsi conservé.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Quel est le pourcentage de pertes d’abeilles chaque hiver en France ?\"," +
                " 3,\"5 à 10%\",\"70 à 75%\",\"25 à 30%\"," +
                "\"Cette espèce si nécessaire à la vie sur Terre est pourtant décimée par l’Homme.\"," +
                "\"En France, les abeilles accusent des pertes de 25 à 30 % chaque hiver. Cette étude est révélatrice d’un dérèglement important de notre écosystème. D’après des chiffres publiés par Greenpeace en 2016, les abeilles contribuent à 75 % de la production alimentaire mondiale grâce à la pollinisation. Sans insectes pollinisateurs, nous pourrions abandonner pommes, artichauts, oignons, citrons et autres plaisirs papillaires.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"En combien d’années la population de requin a diminué de 80 % ?\"," +
                " 2,\"5 ans\",\"15 ans\",\"40 ans\"," +
                "\"Selon WWF, plus de 100 millions de requins sont tués chaque année.\"," +
                "\"Plus de 100 millions de requins, provenant de 380 espèces différentes, sont tués chaque année. Les chasseurs prélèvent les ailerons, mais aussi la chair, la peau et le cartilage, utilisé en médecine. La pollution des eaux, qui perturbe les cycles de reproduction,  est également responsable de la diminution de l’espèce.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Combien de pourcentage de surface de l’habitat des koalas ont été détruit lors des incendies de 2019/2020 dans la région du sud-est en Australie ?\"," +
                " 1,\"30 %\",\"5%\",\"60 %\"," +
                "\"Près de 30 % des koalas du sud-est pourraient avoir été tués dans les incendies.\"," +
                "\"Les koalas étaient déjà menacés d'extinction, et sont passés de plusieurs millions au siècle dernier à quelques dizaines de milliers, le chiffre consensuel est de 28 000. La perte s'élèverait à un tiers de la population (10 000). Les conséquences sur les koalas sont particulièrement importantes car si des animaux comme les kangourous, les cerfs, ou encore les dingos (chiens sauvages) peuvent s'enfuir ce n'est pas le cas des koalas, qui se retrouvent à grimper en haut des arbres en feu.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Quel est le pourcentage d’espèces dans la nature qui restent inconnues ?\"," +
                " 3,\"25 %\",\"60 %\",\"90 %\"," +
                "\"71 nouvelles espèces ont été identifiées dans le monde en 2019.\"," +
                "\"Les spécialistes de la biodiversité estiment que plus de 90% des espèces de la nature restent inconnues. Une riche diversité de plantes et d'animaux, ce qui permet à la vie sur notre planète de prospérer.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Parmis ces espèces laquelle a été découverte en 2017 ?\"," +
                " 1,\"Le rat géant Vangunu\",\"L’Homo Naledi\",\"Le dragon de Komodo\"," +
                "\"Le dragon de Komodo est une espèce de lézard qui a été découverte en 1912.\"," +
                "\"Les habitants des Îles Salomon parlaient depuis longtemps du rat géant Vangunu de près d'un kilo qui se nourrit de noix de coco, mais aucun scientifique n'avait jamais confirmé son existence... avant qu'un garde forestier en attrape un qui s'échappait d'un arbre que des bûcherons venaient d'abattre.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"De combien diminuera la population des ours polaires d’ici à 2050 ?\"," +
                " 1,\"66 %\",\"44%\",\"2 %\"," +
                "\"On estime que l'espèce pourrait disparaître d'ici un siècle à cause de la réduction de la superficie et de la qualité de son habitat.\"," +
                "\"L'avenir de ce prédateur est malheureusement connu. La banquise arctique où l'animal chasse disparaît peu à peu durant l'été. La banquise se reforme de plus en plus tard l'automne et fond de plus en plus tôt au printemps. Selon certains rapports, les ours polaires pourraient aussi bien venir à terre pour se nourrir d’aliments terrestres, et ainsi se passer de la banquise. Mais nous n'avons aucune preuve qu'ils en soient capables.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Lequel de ces animaux est aussi responsable de la pollution ?\"," +
                " 2,\"Le chien\",\"La vache\",\"L'éléphant\"," +
                "\"C’est un herbivore\"," +
                "\"La vache produit du méthane en pétant, c’est un gaz à effet de serre très nocif Les vaches françaises émettent autant de gaz en un an que 15 millions de voitures !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Quel est l’animal le plus ancien vivant encore sur Terre ?\"," +
                " 3,\"Le crocodile\",\"Le mathusalem\",\"Le coelacanthe\"," +
                "\"On le trouve dans l’Océan Indien\"," +
                "\"C’est le coelacanthe (un gros poisson carnivore dont le plus ancien fossile date de 400 millions d’années), que l’on croyait disparu il y a 70 millions d’années. Les paléontologues ont donc été stupéfaits d’en trouver un vivant en 1938, sur les côtes d’Afrique du Sud. Depuis, environ 200 spécimens ont été pêchés dans l’océan Indien.\");");
    }

    public void insertNewAnimauxV2V3(SupportSQLiteDatabase db){

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",1," +
                "\"Lequel de ces animaux est aussi responsable de la pollution ?\"," +
                " 2,\"Le chien\",\"La vache\",\"L'éléphant\"," +
                "\"C’est un herbivore\"," +
                "\"La vache produit du méthane en pétant, c’est un gaz à effet de serre très nocif Les vaches françaises émettent autant de gaz en un an que 15 millions de voitures !\");");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",2," +
                "\"Quel est l’animal le plus ancien vivant encore sur Terre ?\"," +
                " 3,\"Le crocodile\",\"Le mathusalem\",\"Le coelacanthe\"," +
                "\"On le trouve dans l’Océan Indien\"," +
                "\"C’est le coelacanthe (un gros poisson carnivore dont le plus ancien fossile date de 400 millions d’années), que l’on croyait disparu il y a 70 millions d’années. Les paléontologues ont donc été stupéfaits d’en trouver un vivant en 1938, sur les côtes d’Afrique du Sud. Depuis, environ 200 spécimens ont été pêchés dans l’océan Indien.\");");

    }

    public void insertChiffresCles(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Combien de pourcentage de la surface terrestre est dédiée à l’agriculture et à l’élevage ?\"," +
                " 2,\"56%\",\"33%\",\"26%\"," +
                "\"En France, la SAU (surface agricole utilisée) représente 54% du territoire national.\"," +
                "\"Malgré ce fort pourcentage qui représente 49 millions de km² (environ la superficie de l’Asie) de nombreux pays souffre de sous-alimentation ...\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Quelle est la taille du plus grand vortex de déchets ?\"," +
                " 1,\"1.6 million de km\",\"130 000 km\",\"1.2 million de km\"," +
                "\"Il est composé de 80 000 tonnes de déchets plastiques.\"," +
                "\"C'est une décharge de plastique qui flotte entre le Japon et les États-Unis. Elle  représente 1,6 million de km².\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Quel est le pourcentage de déchets recyclés ou compostés ?\"," +
                " 3,\"24%\",\"35%\",\"19%\"," +
                "\"37% sont enfouis sous terre, 33 % sont laissés à ciel ouvert & 11 % sont incinérés.\"," +
                "\"Aujourd'hui, la grande majorité des déchets municipaux sont mis en décharge. Le recyclage est encore une prérogative des pays riches Dans les pays à faible revenu, 93 % des déchets finissent dans des décharges en plein air plus ou moins bien gérées.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Quel est le pays qui utilise le plus les énergies renouvelables ?\"," +
                " 2,\"Norvège\",\"Islande\",\"Suède\"," +
                "\"Île de l'océan Atlantique nord, au nord-ouest des îles Féroé.\"," +
                "\"L’Islande est actuellement la seule nation dont 100 % de l’énergie qu’elle consomme est dite verte et renouvelable. La part de la consommation d'énergie renouvelable en France est d’environ 16%. Le nucléaire, les produits pétroliers et le gaz restent ses sources d’énergie principales. Avec la loi relative à la transition énergétique pour la croissance verte, promulguée le 18 août 2015, la France s’est fixée pour objectif d’atteindre 32 % d’énergies renouvelables dans la consommation totale d’énergie de la France à horizon 2030.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Quelle est l’énergie renouvelable la plus utilisée en France ?\"," +
                " 2,\"Hydraulique\",\"Bois\",\"Eolien\"," +
                "\"C’est une énergie renouvelable utilisée comme combustible.\"," +
                "\"En France, l’utilisation du bois dans la part des énergies renouvelables est de 41.2%, l’hydraulique de 19.8% et l’éolien de 7.1%\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"Quelle est le nombre d’arbres coupés chaque année sur la Terre ?\"," +
                " 1,\"15 milliards d’arbres\",\"60 millions d’arbres\",\"4 milliards d’arbres\"," +
                "\"Une étude menée en 2015 montrait qu’il y avait environ 3400 milliards d’arbres sur notre planète.\"," +
                "\"Depuis les débuts de l'agriculture, il y a 12 000 ans environ, le nombre d'arbres sur Terre aurait chuté de 46 % ! Et avec eux, toute une biodiversité, des espèces animales et végétales, pour certaines disparues à jamais…\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",1," +
                "\"De combien la température mondiale à augmenter depuis 1900 ?\"," +
                " 3,\"1.5 °C\",\"2.0 °C\",\"1.0 °C\"," +
                "\"Les vagues de froid hivernales dans une grande moitié de l'hémisphère nord durent deux semaines de moins qu'il y a 100 ans.\"," +
                "\"Le réchauffement climatique cause de nombreux dégâts et en particulier la fonte des glaces : depuis la fin des années 1960, la couverture neigeuse mondiale a décru d’environ 10 à 15%. Si les glaciers venaient tous à fondre, le niveau des océans augmenterait d’environ 40 cm.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"Quelle ville est la moins polluée en France ?\"," +
                " 3,\"Grenoble\",\"Albertville\",\"Roisey\"," +
                "\"Ce n'est pas toujours les villes entourées de montagnes/campagnes qui ont l'air le plus pur.\"," +
                "\"Ville ou campagne, la pollution n’a pas de frontière. Trois critères sont à prendre en compte : les émissions de polluants, la topographie (plaines, montagnes, zones côtières ...) ainsi que les conditions météorologiques.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"En 2017, Quelle était la puissance développée par le parc Français éolien ?\"," +
                " 3,\"14.3 GW\",\"60.8 GW\",\"13.6 GW\"," +
                "\"3 régions totalisent quasiment 60 % de la production d’électricité d’origine éolienne nationale. Il s’agit du Grand-Est (3.1 GW), des Hauts de France (3.36 GW) et de l’Occitanie (1.4 GW).\"," +
                "\"L’Allemagne possède le parc le plus important (108 GW) devant l’Italie (60,8 GW) et l’Espagne (51,9 GW). Le parc français est le quatrième plus important d’Europe avec 13,6 GW de capacités installées en 2017 (il y a 6500 éoliennes installées en France).\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"En m3, Quel est le volume de retenue du Barrage de Petit-saut en Guyane ?\"," +
                " 3,\"1 500 000 000\",\"985 000\",\"3 500 000 000\"," +
                "\"Le Barrage de Petit-saut a une superficie de 310 km².\"," +
                "\"Le Barrage de Petit-saut mesure 37 m de haut pour une superficie de 310km². Son volume de retenue en millions de m3 est de 3500. C'est le plus grand barrage français !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"En 2018, Quelle était la part du marché des véhicules électriques en France ?\"," +
                " 1,\"2.2 %\",\"46.7 %\",\"5.4 %\"," +
                "\"La France n’a pas encore franchi le pas dans les véhicules électriques.\"," +
                "\"En France, les voitures électriques représentaient 2,2 % (2018) de parts du marché français, contre 46,7 % en Norvège ou encore 6,6 % aux Pays-Bas.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"Sur Terre, Quelle est le pourcentage d’eau salée ?\"," +
                " 2,\"91.7 %\",\"97.5 %\",\"80.3 %\"," +
                "\"Sur Terre, il y a 35.2 millions de milliards de mètres cubes d’eau douce.\"," +
                "\"Seuls 2.5% de l’eau sont de l’eau douce, soit environ 35.2 millions de milliards de mètres cubes d’eau douce. Cette quantité d’eau douce se trouve : 68,7 % dans les glaciers, 30,1 % dans les nappes phréatiques, 0,8 % dans le permafrost (roche gelée) et 0.4 % dans l’atmosphère. Au final, moins de 1 % de l'eau sur Terre est de l'eau douce et liquide.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"Combien de milliards de mètres cubes d’eau douce le lac Baïkal contient-il ?\"," +
                " 1,\"23 000\",\"5 000\",\"32 000\"," +
                "\"Sa superficie est de 31 722 km² (environ celle de la Belgique) et sa profondeur moyenne est de 744 m.\"," +
                "\"Le lac Baïkal, avec ses 23.000 milliards de mètres cubes d'eau, constitue le plus grand réservoir d'eau douce liquide de la surface de la planète. Il est classé au Patrimoine mondial de l'humanité pour la richesse de la faune qu'il abrite.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",2," +
                "\"Quel est le pourcentage d'oxygène que fournit l’amazonie sur Terre ?\"," +
                " 2,\"50%\",\"20%\",\"10%\"," +
                "\"L’amazonie c’est 10% de la biodiversité mondiale\"," +
                "\"Poumon de la planète, l'Amazonie c’est : 6,7 millions de km² de forêts, 17 à 20% de l'eau douce du monde et 20% de l'oxygène sur terre.\");");
    }

    public void insertLesBases(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Qu’est-ce-que le recyclage ?\"," +
                " 1,\"Récupérer des déchets et les réintroduire, après traitement\",\"Incinérer des déchets.\",\"Revendre des produits déjà utilisés sans les transformer.\"," +
                "\"Le recyclage est un procédé de traitement des déchets\"," +
                "\"Le recyclage permet de réduire les volumes de déchets et de préserver les ressources naturelles en réutilisant des matières premières déjà extraites.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Qu'est ce qu’une énergie renouvelable ?\"," +
                " 1,\"Une énergie inépuisable\",\"Une énergie qui prends du temps à se renouveler\",\"Une énergie bonne pour la santé\"," +
                "\"Ce n’est pas parce que c’est bon pour la planète que c’est bon pour la santé.\"," +
                "\"Les énergies renouvelables (EnR) sont des sources d'énergie dont le renouvellement naturel est assez rapide pour qu'elles puissent être considérées comme inépuisables à l'échelle du temps humain. Elles proviennent de phénomènes naturel (Soleil , Lune (marées), Vent ...).\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Comment fonctionne un véhicule électrique ?\"," +
                " 2,\"Avec de l'électricité en courant alternatif\",\"Avec une batterie\",\"Avec une batterie et de l’huile pour refroidir le moteur\"," +
                "\"Son fonctionnement est bien plus simple qu’une voiture diesel ou essence.\"," +
                "\"la voiture électrique est dépourvue de boîte de vitesse. Elle est inutile car un moteur électrique est capable de fonctionner sans problème jusqu’à plusieurs dizaines de milliers de tours par minute. Il fournit directement la rotation contrairement à un moteur thermique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Parmis ces technologies, laquelle génère de l'électricité grâce au vent ?\"," +
                " 3,\"Solaire photovoltaïque\",\"Hydraulique\",\"Eolien\"," +
                "\"Merci d’avoir cliqué sur moi pour cette question, je me pensais inutile.\"," +
                "\"L’énergie éolienne représente 7.1% dans les énergies renouvelables utilisées en France, le solaire photovoltaïque 2.7 % et l’hydraulique 19.8%.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Qu'est ce que la pollution ?\"," +
                " 1,\"Dégradation de l'environnement\",\"Dégradation du ciel\",\"Dégradation de la santé\"," +
                "\"Bien qu’elle dégrade la santé des humains, cela ne fait pas partie de sa définition.\"," +
                "\"La pollution est la dégradation de l'environnement par des substances, des déchets ou des nuisances diverses. Bien qu'elle puisse avoir une origine entièrement naturelle (éruption volcanique), elle est principalement liée aux activités humaines.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Quelle est l’une des conséquences de la déforestation parmi ces propositions ?\"," +
                " 2,\"Apparition de nouvelles espèces\",\"Réchauffement climatique\",\"Manque de papier\"," +
                "\"On le verra dans le long terme.\"," +
                "\"La déforestation a un impact très fort sur le changement climatique. les arbres stockent du CO2 tout au long de leur vie. En détruisant ces arbres, on réduit la capacité de l'écosystème mondial à stocker du CO2.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",1," +
                "\"Qu’est-ce-que l’agriculture extensive ?\"," +
                " 3,\"Production agricole cherchant à maximiser la production.\",\"Production agricole qui a un impact sur l’environnement\",\"Production agricole fondée sur l’utilisation des ressources naturelles.\"," +
                "\"L’agriculture extensive c’est le contraire de l’agriculture intensive.\"," +
                "\"L’élevage extensif est un type d’élevage qui est essentiellement fondé sur l’utilisation des ressources naturelles disponibles : eau, pâturage, etc. Le système de production se base sur le pâturage. Il se pratique en général sur de vastes espaces auxquels les animaux accèdent en se déplaçant. Il s’agit de produire un peu moins, mais mieux.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Qui est surnommé le poumon vert de la planète ?\"," +
                " 1,\"La forêt amazonienne\",\"La Taïga, une immense forêt polaire\",\"La forêt de Daintree en Australie\"," +
                "\"Elle s'étend sur près de 6 millions de km2. Cela ne représente pas moins de 400 milliards d’arbres.\"," +
                "\"Près des deux tiers de sa surface se trouvent au Brésil, mais elle touche également huit autres pays, parmi lesquels la France, par le biais de la Guyane. Et elle est inscrite au patrimoine mondial de l’Unesco. Malheureusement, ce trésor est menacé par la déforestation. Entre août 2015 et juillet 2016 par exemple, ce ne sont pas moins de 8.000 km2 de forêt qui ont été détruits.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Ou se trouve la grand barrière de corail ?\"," +
                " 3,\"Crête\",\"Ile Maurice\",\"Australie\"," +
                "\"Elle s’étend sur 344 400 km², la Grande barrière se situe au large du Queensland en mer de Corail.\"," +
                "\"Située dans l’océan Pacifique, la Grande barrière de corail australienne est le plus grand système corallien et la plus grande structure vivante de la planète. Elle est l’une des sept merveilles naturelles du monde.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Qu’est-ce-qu’un récif ?\"," +
                " 2,\"Une plante dans la mer\",\"Une chaîne de rochers\",\"Un poisson\"," +
                "\"Un récif est une structure naturelle.\"," +
                "\"Le récif peut être soit une chaîne de rochers (à fleur d'eau ou submergée), soit une structure créée par l'accumulation de certains organismes vivants marins, dont les plus connus sont les récifs de coraux des mers tropicales.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Qu’est-ce-qu’un corail ?\"," +
                " 1,\"Un animal qui vit dans les mers chaudes\",\"Un rocher\",\"De la végétation\"," +
                "\"En s’assemblant, les coraux forment des récifs coralliens abritant 25% de la vie marine de notre planète.\"," +
                "\"Le corail est un animal de la famille des cnidaires qui vit souvent en colonie dans des mers chaudes. Il possède un orifice entouré de tentacules qui permettent de capturer des proies pour se nourrir. Le corail fabrique un squelette externe calcaire et dur qui participe à la construction d'un récif corallien.Aujourd'hui, le corail est menacé dans le monde, en raison du réchauffement du climat. Le corail peut être de différentes couleurs. Il existe notamment le corail rouge.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Qu'est ce que le réchauffement climatique ?\"," +
                " 3,\"Phénomène d’augmentation du niveau de la mer.\",\"Phénomène d'accroissement de l’effet de serre.\",\"Phénomène d'augmentation des températures moyennes.\"," +
                "\"Attention parmis ces réponses, certaines sont des conséquences du réchauffement.\"," +
                "\"Le réchauffement climatique, ou réchauffement planétaire, est le phénomène d'augmentation des températures moyennes océaniques et atmosphériques, du fait d'émissions de gaz à effet de serre excessives.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"Qu’est-ce-que la Biodiversité ?\"," +
                " 1,\"Toutes les espèces vivantes sur la Terre\",\"Les êtres humains\",\"Les êtres humains et  les animaux\"," +
                "\"La faune et la flore\"," +
                "\"La Biodiversité est l'ensemble des espèces vivantes et la diversité biologique. Elle englobe la diversité des gènes, des espèces et des écosystèmes. Elle comprend également le fait que ces niveaux interagissent.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",2," +
                "\"La pollinisation, c’est la disparition des abeilles ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"Les pollinisateurs les plus emblématiques et les mieux connus du grand public sont l'abeille domestique.\"," +
                "\"La pollinisation consiste en l’action de transporter du pollen afin de féconder des plantes.\");");
    }

    public void insertLesPhotos(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"LesPhotos\",2," +
                "\"Comment surnomme-t-on ce vortex de déchets ?\"," +
                " 1,\"Le 7ème continent\",\"Le continent de déchets\",\"La mer de plastique\"," +
                "\"Il se trouve dans le Pacifique Nord\"," +
                "\"Au nord-est de l'océan Pacifique, se trouve un point de rencontre de nombreux courants océaniques. C'est ici qu'a été découvert en 1997 ce fameux 7e continent, composé de déchets produits par l'activité humaine.\");");
    }

    public void insertTopNewsLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Aux Philippines, combien d'arbres les étudiants doivent-ils planter pour être diplômés ?\"," +
                " 1,\"10 arbres\",\"1 arbres\",\"5 arbres\"," +
                "\"Aux Philippines, les étudiants doivent planter plus d'un arbre pour être diplômés.\"," +
                "\"En vertu d'une nouvelle loi, les élèves qui terminent leurs études primaires, secondaires et universitaires doivent planter 10 arbres chacun avant de pouvoir obtenir leur diplôme. Les arbres peuvent être plantés dans les forêts, les mangroves, les réserves, les zones urbaines, les sites miniers abandonnés ou le territoire indigène.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"L'année dernière, quel pays était le plus impliqué pour l'écologie ?\"," +
                " 1,\"Suisse\",\"France\",\"Danemark\"," +
                "\"c'est un pays montagneux d'Europe centrale.\"," +
                "\"C'était la Suisse avec une première place en termes d'écologie dans le monde en 2019 selon l'IPE. Les pays sont jugés sur des critères de pollution de l'air, de qualité de l'eau, de gestion des ressources naturelles…\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"En 2016, le Bhoutan (petit pays voisin de l'Inde) retire plus de carbone qu'il n'en produit ?\"," +
                " 1,\"vrai\",\"faux\",\"ne sais pas\"," +
                "\"le  Bhoutan a produit 2,2 millions de tonnes de CO2.\"," +
                "\"En 2016, le Bhoutan (petit pays voisin de l'Inde) a produit 2,2 millions de tonnes de CO2. Cependant, leurs forêts ont éliminé 3 fois cette quantité, ce qui en fait un puits de carbone pour 4 millions de tonnes de CO2 par an.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"A  partir de quelle année les ventes de voitures diesel et essence seront-elles interdites en Californie ?\"," +
                " 2,\"2025\",\"2035\",\"2050\"," +
                "\"Dans une décennie, les ventes de voitures diesel et essence seront interdites.\"," +
                "\"Contre la pollution de l'air et le réchauffement climatique, le gouverneur démocrate de Californie prend le taureau par les cornes: à partir de 2035, les ventes de voitures diesel et d'essence neuve seront purement et simplement interdites.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Sera-t-il encore possible de se diriger vers une terrasse chauffée pour prendre un verre en France en 2021 ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"A partir de la fin de l'hiver 2021, cette décision pourra être mise en œuvre.\"," +
                "\"Il ne sera bientôt plus possible de se rendre sur une terrasse chauffée pour prendre un verre ou pour déguster un plat à l'extérieur. C'est la décision prise par le gouvernement français le lundi 27 juillet 2020.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Grâce à la crise sanitaire de début 2020, combien de semaines le jour du débordement des ressources de la terre a-t-il reculé ?\"," +
                " 3,\"1 semaine\",\"5 semaines\",\"3 semaines\"," +
                "\"Pour la première fois depuis les années 1970, «Earth's Passing Day» est retardé.\"," +
                "\"La pandémie aura eu au moins un effet positif: avec le trafic aérien suspendu, les transports et l'industrie arrêtés, la planète a pu, pendant quelques mois, respirer à nouveau. En conséquence, pour la première fois depuis les années 1970, le «Jour de la Terre qui passe» est retardé.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"La musaraigne éléphant avait-elle vraiment disparu ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"L'animal, semblable à une souris, vit dans les zones rocheuses de la Corne de l'Afrique.\"," +
                "\"L'animal, semblable à une souris, a été répertorié comme l'une des «25 espèces perdues les plus recherchées» de la Global Wildlife Conservation. Il faut dire que depuis 1973, l'insectivore semblait s'être éteint, du moins c'est ce que pensaient les scientifiques. En réalité, la musaraigne éléphant (ou Elephantulus Revoilii) a continué à vivre sa vie, loin de l'homme, dans les zones rocheuses de la corne de l'Afrique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"topnews\",3," +
                "\"Quelle entreprise a fabriqué le premier train à hydrogène ?\"," +
                " 3,\"TrainCompany\",\"H2OFaster\",\"Alstom\"," +
                "\"Le train a été fabriqué par une entreprise française.\"," +
                "\"Fabriqué par la société française Alstom, le premier train à hydrogène est désormais en circulation en Allemagne. Reliant les villes de Cuxhaven, Bremerhaven, Bremervörde et Buxtehude sur une distance de 100 kilomètres, ce train peut accueillir 300 passagers et circuler à 140 km / h. L'avantage est qu'il n'émet que de la vapeur d'eau d'une pile à combustible qui convertit l'hydrogène sous forme gazeuse en électricité.\");");

    }

    public void insertChiffreClesLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Quelle est l'altitude du mont Everest ?\"," +
                " 1,\"8849 m\",\"4810 m\",\"6699 m\"," +
                "\"L’Everest est le toit du monde !\"," +
                "\"Avec une altitude de près de 8850 m, l’Everest est le toit du monde. Le mont Blanc, plus haut sommet d’Europe, atteint à peine 4810 m.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"La terre est née il y a environ ...?\"," +
                " 2,\"4,5 millions d’années\",\"4,5 milliards d’années\",\"550 000 ans\"," +
                "\"Selon les connaissances actuelles, l’âge de la Terre est de (4,54 x 109 ans ± 1 %).\"," +
                "\"La Terre était un nuage de gaz et de poussière qui s’est lentement condensé sous l’action des forces de gravité. Les scientifiques appellent ce phénomène “l’accrétion”.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Au bout de combien d’années les volcans qui ne sont pas entrés en éruption sont dits des volcans “éteints” ?\"," +
                " 3,\"100 ans\",\"6000 ans\",\"10000 ans\"," +
                "\"Un volcan est considéré comme endormi lorsqu'il a connu sa dernière éruption entre 10 000 ans et il y a quelques centaines d'années.\"," +
                "\"Il faut attendre plusieurs milliers d’années pour savoir si un volcan est éteint ou juste endormi. Et cela reste incertain. En 1973, un volcan proche de l’Islande est entré en éruption après un sommeil de plus de 5000 ans !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Combien mesure en hauteur le volcan “Olympus Mons” sur Mars ?\"," +
                " 1,\"22.5 km\",\"15.2 km\",\"1514 m\"," +
                "\"Olympus Mons mesure plus de 5 fois le mont Blanc !\"," +
                "\"Mars exhibe le plus grand volcan du système solaire. Mais rien à craindre pour nos futurs explorateurs : tous ces volcans sont éteints depuis plusieurs millions d’années.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Quel est le jour le plus long de l’année dans l’hémisphère nord ?\"," +
                " 2,\"Le 21 décembre\",\"Le 21 juin\",\"Le 21 mars\"," +
                "\"On appelle cette date le solstice d’été.\"," +
                "\"On appelle cette date le solstice d’été. L’hémisphère nord reçoit le maximum d’ensoleillement. Et lors du solstice d’hiver, le 21 décembre, on a la journée la plus courte de l’année. Alors que dans l’hémisphère sud c’est l’inverse !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"A quoi correspond le “zéro absolu” ?\"," +
                " 3,\"-0°C\",\"0°C\",\"-273,15°C\"," +
                "\"Les scientifiques utilisent ce terme très fréquemment.\"," +
                "\"Le “zéro absolu” correspond à une température de -273,15°C donc bien en-dessous de 0°C. C’est en fait le zéro de l’échelle thermométrique Kelvin que les scientifiques utilisent très fréquemment.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Chiffre\",3," +
                "\"Les océans et les mers recouvrent une grande partie du globe terrestre. Ils occupent ?\"," +
                " 1,\"Environ 70% de la surface totale\",\"Environ 60% de la surface totale\",\"Environ 55% de la surface totale\"," +
                "\"On appelle la Terre la “planète bleue” parce qu'elle est principalement constituée d'eau.\"," +
                "\"Les océans et les mers recouvrent 71% de la surface de notre planète. Ils constituent, entre autres, un réservoir de chaleur qui circule grâce aux courants marins (cf.GulfStream->QuizDeLaCommunauté).\");");
    }

    public void insertLesBasesLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"Quels sont les trois piliers essentiels du développement durable ?\"," +
                " 1,\"Économique, Social et Environnement\",\"Économique, Santé et Environnement\",\"Economique, Justice et Environnement\"," +
                "\"Le pilier social comporte un aspect vivable et équitable.\"," +
                "\"Le développement durable est un développement qui répond aux besoins des générations présentes sans compromettre la capacité des générations futures de répondre aux leurs.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"Quel est le plus grand désert du monde ?\"," +
                " 2,\"Le désert du Nevada\",\"Le désert du Sahara\",\"Le désert de Gobi\"," +
                "\"La superficie du désert de Gobi est de 1,295 million de km².\"," +
                "\"Le Sahara s’étend sur 8 millions de kilomètres carrés. C’est 15 fois la superficie de la France !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"L’amplitude entre le niveau le plus haut et le niveau le plus bas de la mer dans la baie du Mont-Saint-Michel correspond à bâtiment de ?\"," +
                " 3,\"dix étages\",\"un étage\",\"cinq étages\"," +
                "\"La différence entre les deux niveaux peut dépasser les quinze mètres.\"," +
                "\"Lors des fortes marées bimensuelles, la différence entre une basse et une haute mer peut dépasser les quinze mètres ! Et comme le terrain est très plat, la mer se retire alors à une vingtaine de kilomètres à marée basse.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"Avec quelle échelle mesure-t-on l’énergie libérée par un séisme ?\"," +
                " 1,\"L’échelle de Richter\",\"L’échelle de Newton\",\"L’échelle de Parker\"," +
                "\"L’échelle Newton est une échelle de mesure de température.\"," +
                "\"L’échelle de Richter fut mise au point par le sismologue américain Charles Richter en 1935. Elle indique la magnitude, qui mesure l’énergie libérée par le séisme.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"Qu’est ce qu’une forêt dite “primaire” ?\"," +
                " 2,\"Est âgée de moins de 10 ans\",\"N’a jamais subi l’influence de l’Homme\",\"Se trouve en plaine ou à basse altitude\"," +
                "\"Les forêts primaires sont particulièrement protégées.\"," +
                "\"Dans les forêts primaires / primitives, la nature évolue sans l’impact de l’homme. Ces forêts sont particulièrement protégées car elles constituent un patrimoine précieux, servant de laboratoire de recherches et de conservatoire de plantes et d’animaux.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"Que peut-on dire des dimensions d’un fleuve par rapport à celles d’une rivière ?\"," +
                " 3,\"Un fleuve est toujours plus long qu’une rivière\",\"Un fleuve est toujours plus large qu’une rivière\",\"Elles ne permettent pas de distinguer un fleuve d’une rivière.\"," +
                "\"Un fleuve n’est pas particulièrement plus large qu’une rivière.\"," +
                "\"La longueur ou la largeur ne différencient pas un fleuve d’une rivière mais c’est le lieu sur lequel ils débouchent : un fleuve se jette dans la mer alors qu’une rivière se jette dans un fleuve ou dans une autre rivière.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Lesbases\",3," +
                "\"A quelle température l’eau de mer gèle-t-elle ?\"," +
                " 1,\"-2 °C\",\"2°C\",\"0°C\"," +
                "\"La salinité de l’eau de mer impact sur le point de congélation de l’eau.\"," +
                "\"L’eau douce gèle à 0°C, mais la salinité de l’eau de mer abaisse son point de congélation à -2°C.\");");
    }
    public void insertAnimauxLVL3(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Pourquoi le poisson n’a-t-il pas froid dans l’eau ?\"," +
                " 3,\"Ses écailles le protègent du froid\",\"Sa température est plus basse que celle de l’eau\",\"Sa température est à peu près identique à celle de l’eau\"," +
                "\"Les poissons sont des animaux à température variable.\"," +
                "\"Les poissons sont des animaux à température variable, c’est-à-dire en adéquation avec celle des eaux dans lesquelles ils vivent.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Le ptérodactyle vivait il y a 150 millions d’années. Il volait au-dessus de l’Europe, de l’Afrique et de l’Asie. C’était un ?\"," +
                " 1,\"Reptile volant\",\"Dinosaure\",\"Oiseau\"," +
                "\"Les dinosaures ne se déplacent que sur la terre ferme.\"," +
                "\"Les dinosaures ne se déplacent que sur la terre ferme. Ils ne volent pas et ne nagent pas ! Quant aux oiseaux, ils ont pour ancêtres les dinosaures.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Les paresseux ont une fourrure verdâtre. Sais-tu pourquoi ?\"," +
                " 3,\"Les feuilles des arbres déteignent sur leur pelage\",\"Les paresseux sont végétariens et suent un liquide vert\",\"Des algues vertes se développent sur leur fourrure\"," +
                "\"Les paresseux doivent se cacher dans les arbres.\"," +
                "\"Les paresseux sont des mammifères d’Amérique du Sud qui vivent dans les arbres et se déplacent très lentement. Ne pouvant pas fuir à grande vitesse, cette parure est un bon camouflage contre leurs ennemis.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Quand une personne possède une très bonne vue, on dit qu’elle a des yeux de ...?\"," +
                " 2,\"Boeuf\",\"Lynx\",\"Biche\"," +
                "\"Elle a les yeux d’un carnivore.\"," +
                "\"Le Lynx est un mammifère carnivore fort et agile qui n’a pas un très bon flair mais qui possède en revanche une vue perçante et une ouïe excellente.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Dans Le Roi Lion, Pumbaa, l’ami de Simba, est un ?\"," +
                " 3,\"Cochon d’Inde\",\"Suricate\",\"Phacochère\"," +
                "\"Pumbaa est un cousin du sanglier.\"," +
                "\"Un phacochère est un cochon sauvage d’Afrique, cousin du sanglier. Alors qu’un suricate est une sorte de petite mangouste.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Le krill est une importante source de nourriture pour les baleines, les phoques et les oiseaux de l’Antarctique. Qu’est-ce que c’est ?\"," +
                " 1,\"Un banc de curstacés minuscules\",\"Un groupe d’algues vertes\",\"Un banc de poissons microscopiques\"," +
                "\"Le krill est un regroupement de toutes petites espèces.\"," +
                "\"Avant d’être mangés à leur tour, les crustacés du krill se nourrissent de végétaux marins et de minuscules animaux. Lorsqu’ils sont rassemblés en banc, l’océan paraît rouge.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"Animaux\",3," +
                "\"Comment les charmeurs de serpents, charment ces reptiles ?\"," +
                " 3,\"Grâce aux sons produits par la flûte\",\"En les regardant fixement dans les yeux\",\"En agitant la flûte devant eux\"," +
                "\"Les serpents sont sourds.\"," +
                "\"Les serpents sont sourds. Lorsque les charmeurs agitent leur flûte devant les serpents, ceux-ci se croient agressés. Ils se cambrent en position de défense et bougent en suivant la flûte qu’ils prennent pour un prédateur.\");");
    }


}
