package com.momiouo.naturequiz.data.datasource.db;

import androidx.sqlite.db.SupportSQLiteDatabase;

public class DBFireDB {
    public void insertDecentralisation(SupportSQLiteDatabase db){
        //Datacenter 1
        String decentralisation = "digital";
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"Que contient un datacenter ?\"," +
                " 1,\"Des serveurs, des baies de stockage, ...\",\"Différentes variétés d’espèces végétales\",\"Des lettres, des courriers, …\"," +
                "\"Les datacenters utilisent beaucoup d'électricité.\"," +
                "\"Un datacenter regroupe des équipements (ordinateurs centraux, serveurs, baies de stockage, équipements réseaux et de télécommunications, etc.). Il fournit des services informatiques en environnement contrôlé (climatisation) et sécurité (système anti-incendie, contre le vol et l'intrusion, etc.).\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"Quel est le pourcentage des émissions mondiales de gaz à effet de serre des datacenters ?\"," +
                " 2,\"1.2%\",\"0.3%\",\"2.6%\"," +
                "\"La réponse 3 n’est pas la bonne réponse.\"," +
                "\"Les centres de données sont responsables de 0,3 % des émissions mondiales de gaz à effet de serre. Les centres informatiques représentent moins de 15 % de l'impact environnemental du numérique à l'échelle mondiale, tandis que les équipements utilisateurs en concentrent les deux tiers, et le réseau la part restante. Rappelons que, selon l'association française The Shift Project, le numérique dans son ensemble était responsable de 3,7 % des émissions de CO2 mondiales en 2018, contre 2,5 % en 2013.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"Qu’est ce que la dématérialisation ?\"," +
                " 3,\"Disparition des supports matériels\",\"Remplacement des fichiers informatiques par des supports matériels\",\"Remplacement support matériels par des fichiers informatiques et des ordinateurs\"," +
                "\"Le concept de la dématérialisation est de remplacer les supports matériels.\"," +
                "\"La dématérialisation est le remplacement dans une entreprise ou une organisation de ses supports d'informations matériels (souvent en papier) par des fichiers informatiques et des ordinateurs. On parle aussi d'informatisation ou de numérisation.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"A quoi sert la dématérialisation ?\"," +
                " 1,\"Économiser du temps et de la ressource humaine\",\"Meilleure reforestation de la Terre\",\"Moins polluer\"," +
                "\"La dématérialisation concerne surtout l’aspect productivité.\"," +
                "\"La dématérialisation ou numérisation, consiste à virtualiser des documents papiers ou « physiques », devient un outil important de productivité dans les entreprises. En effet, la dématérialisation permet d'économiser du temps, de la ressource humaine et donc de l'argent. source : cpro.fr\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",1," +
                "\"Stocker un email pendant un an émet combien de grammes de CO2 ?\"," +
                " 3,\"100\",\"50\",\"10\"," +
                "\"1 arbre c’est 5kg de CO2 absorbé par an\"," +
                "\"Un français reçoit en moyenne 39 mails par jour. Un envoi de mail avec une pièce jointe peut émettre 19g de CO2. Stocker un mail dans un data center pendant un an émet 10g de CO2. Ainsi, un email entraîne l’émission de 30 grammes de CO2. Et dans le monde, ce sont 281 milliards de mails qui sont envoyés chaque jour. source : leshorizons.net\");");
        //Fin Datacenter 1

        //Kolos Datacenter
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Combien d'emplois directs vont être générés à Ballangen grâce au datacenter Kolos ?\"," +
                " 1,\"2000 à 3000\",\"Plus de 5000\",\"500 à 1000\"," +
                "\"Le datacenter Kolos générera 10 000 à 15 000 emplois indirects grâce au déménagement de personnes dans la communauté dynamique de Ballangen.\"," +
                "\"Kolos est un projet communautaire. Soutenu par cinq maires de la région, le nouveau centre de Kolos créera directement 2 000 à 3 000 nouveaux emplois et générera 10 000 à 15 000 emplois grâce au déménagement de personnes dans la communauté dynamique de Ballangen.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Pourquoi le lieu Ballangen a été choisi pour construire le plus grand datacenter du monde ?\"," +
                " 2,\"Climat frais et instable du Nord\",\"Climat frais et stable du Nord\",\"Climat tempéré et stable de l’Europe\"," +
                "\"Ballangen est une ancienne municipalité du comté de Nordland, en Norvège\"," +
                "\"Le climat frais et stable du nord de la Norvège et la proximité du site avec l'eau permettront de refroidir naturellement les serveurs. Kolos maximisera intelligemment l'énergie verte et les caractéristiques géographiques uniques du nord de la Norvège pour fournir les services de centre de données les plus efficaces.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Quelle sera la superficie de ce datacenter ?\"," +
                " 3,\"500 000m²\",\"400 000m²\",\"600 000m²\"," +
                "\"Une fois achevé, le site dépassera en taille et en capacité le centre de données de Langfang (Chine) qui totalise 585.289 m2.\"," +
                "\"Malgré cette surface de construction non négligeable et peu adéquate dans cet environnement sauvage, Kolos choisira une architecture qui se fond dans le paysage et respectant la culture et le mode de vie de la communauté.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Quelles technologies seront utilisées pour fournir de l'électricité au datacenter “Kolos” (qui consommera à la fin de sa construction jusqu'à 1 gigawatt par an) ?\"," +
                " 1,\"Éolien et hydroélectrique\",\"Solaire et hydroélectrique\",\"Éolien et nucléaire\"," +
                "\"Kolos sera le plus grand centre de données vert au monde, alimenté par une énergie 100% durable.\"," +
                "\"Kolos sera le plus grand centre de données vert au monde, alimenté par une énergie 100% durable issue de l'hydroélectricité et de l'éolien. En tant que leader mondial des énergies renouvelables avec une abondance d'énergie verte à 105,5% de sa capacité, la Norvège était le choix idéal pour l'emplacement du centre de données de Kolos.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",2," +
                "\"Qu'est-ce que Kolos ?\"," +
                " 2,\"Une jeune entreprise américano-suédoise\",\"Une jeune entreprise américano-norvégienne\",\"Une ancienne entreprise américaine\"," +
                "\"Kolos est une jeune entreprise innovante et dynamique.\"," +
                "\"Kolos, une jeune pousse américano-norvégienne, va construire ce qui est présenté comme le plus grand datacenter du monde à Ballangen.\");");
        //Fin kolos datacenter

        //Crypto
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Créer des cryptomonnaies est synonyme de désastre écologique pour certains ?\"," +
                " 1,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"Créer des cryptomonnaies nécessite d'énormes quantités d'énergie électrique.\"," +
                "\"Créer des cryptomonnaies nécessite d'énormes quantités d'énergie électrique, synonyme de désastre écologique pour certains. Les marchands de crypto-monnaies vont devoir s'acheter une bonne conduite et s'inquiéter désormais de leur empreinte carbone.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Le bitcoin repose sur des blocs de transactions codées et authentifiées qui sont produits par ?\"," +
                " 2,\"Des baies de stockage\",\"Des ordinateurs puissants\",\"Des data centers\"," +
                "\"Les transactions se font via les “mineurs”.\"," +
                "\"Bitcoin est basé sur des blocs de transactions codées et authentifiées s'ajoutant les uns aux autres. Ces blocs sont générés par des ordinateurs puissants qui aident à résoudre des équations.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Parmi ces propositions, laquelle permet de limiter l’impact environnemental du minage de la crypto-monnaie ?\"," +
                " 3,\"Le proof of work\",\"Le gaz moutarde\",\"L’utilisation du gaz naturel brûlé\"," +
                "\"Ce gaz est également appelé le “torchage”.\"," +
                "\"Aux États-Unis, des centres de données de génération de bitcoins fonctionnent au gaz naturel brûlé pour limiter l'impact environnemental de la crypto-monnaie.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Le CBECI estime actuellement la consommation d'énergie du bitcoin à son plus haut historique, à 149 TWh qui est l'équivalent de ?\"," +
                " 1,\"~ la consommation totale de l'Égypte.\",\"~ la consommation totale de la Nouvelle-Zélande.\",\"~ la consommation totale de Madagascar.\"," +
                "\"Le CBECI est l'indice de consommation d'électricité du Cambridge Bitcoin.\"," +
                "\"L'indice de consommation d'électricité du Cambridge Bitcoin estime actuellement la consommation d'énergie du Bitcoin sur une base annuelle à un niveau record, à 149 TWh, légèrement moins que la consommation totale d'électricité d'un pays comme l'Égypte.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"" + decentralisation + "\",3," +
                "\"Des solutions sont mises en place pour diminuer la consommation énergétique de la crypto-monnaies telles que ?\"," +
                " 2,\"Utilisation de gaz brûlé et système Proof of Work\",\"Utilisation de gaz brûlé et système Proof of Stake\",\"Utilisation de gaz brûlé et système Proof of Work\"," +
                "\"La deuxième crypto-monnaie prévoit de passer du “proof of work” à un système moins gourmand en énergie, ce qui permettra d'utiliser seulement une partie des processeurs.\"," +
                "\"Certaines crypto-monnaies envisagent de passer du “proof of work” à un système moins énergivore. Cependant, il est difficile de voir le Bitcoin adopter un tel changement, qui risque de rendre le réseau moins décentralisé et sécurisé.\");");
        //Fin Crypto
    }

    public void insertTriAndDecomposition(SupportSQLiteDatabase db){
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Quel est le temps de décomposition du polystyrène ?\"," +
                " 1,\"1000 ans\",\"Entre 250 et 500 ans\",\"100 ans\"," +
                "\"Le polystyrène est un des matériaux les plus longs à se décomposer.\"," +
                "\"Le polystyrène met 1000 ans à se décomposer, il n’est malheureusement pas, ou très peu recyclé car il est composé à 98% de gaz, il ne reste donc que 2% de matières valorisables.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Le plastique a-t-il une durée de décomposition plus longue que le polystyrène ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"La durée de décomposition d’un sac plastique est en moyenne de 450 ans.\"," +
                "\"Le sac en plastique est un véritable problème, il y en a plus de 8 milliards dans la nature au sein de l'Union européenne, c'est aussi le principal meurtrier des animaux marins. Il n’existe presque pas de solution pour le recycler, c'est l'une des principales raisons pour lesquelles le sac en plastique jetable a été interdit à la vente.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"En combien de temps se décompose un ticket de bus ou de métro ?\"," +
                " 3,\"1 à 2 semaines\",\"1 an\",\"4 à 8 semaines\"," +
                "\"C’est plus long que ce que l’on peut y penser !\"," +
                "\"Le temps de décomposition d’un ticket de métro ou de bus est de 4 à 8 semaines. Alors attention jetez vos tickets de bus et de métro dans une poubelle et pas dans la nature !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Qu’est ce qui peut être libéré dans les sols et les eaux lors de la dégradation des déchets en pleine nature ?\"," +
                " 1,\"Des molécules dangereuses\",\"Des bactéries dangereuses\",\"Des virus\"," +
                "\"un seul mégot peut résister de 1 à 5 ans dans la nature. Le jeter dans une rivière pourrait polluer jusqu’à 500 litres d'eau !\"," +
                "\"Les déchets abandonnés dans la nature, en plus de la pollution visuelle qu'ils représentent, constituent un véritable danger pour l'environnement. La dégradation naturelle peut s’avèrer extrêmement longue. De plus, il peut être libéré dans les sols et les eaux des molécules dangereuses, tant pour l’Homme que pour la nature.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Un litre d’huile de vidange d’une durée de vie comprise entre 5 et 10 ans pourrait recouvrir une surface de ?\"," +
                " 2,\"100 m²\",\"1000 m²\",\"10000 m²\"," +
                "\"Un seul litre d’huile de vidange vidé en pleine nature peut empêcher l’oxigénation de l’eau et perturber la faune et la flore pendant plusieurs années.\"," +
                "\"Un seul litre d’huile de vidange se décompose complétement entre 5 et 10 ans, peut couvrir une surface de 1 000 m² et par conséquence empêcher l'oxygénation de l'eau et perturber la faune et la flore pendant plusieurs années.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"En France, la collecte et le traitement des déchets sont organisés en trois filières, lesquelles ?\"," +
                " 3,\"Recyclage, décomposition, incinération\",\"Recyclage, compostage, biomasse\",\"Recyclage, compostage, incinération\"," +
                "\"Le recyclage et le compostage sont deux filières importantes dans la collecte et le traitement des déchets.\"," +
                "\"Heureusement que la collecte et le traitement des déchets sont bien organisés dans la plupart des pays. Les fillières de traitement des déchets en France sont : le recyclage, le compostage et l’incinération. Ces fillières permettent d’accélerer les processus de dégradations des déchets et surtout d’éviter de les retrouver au milieu de la nature !\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Comment savons nous que le verre peut résister plus de 4000 ans dans la nature ?\"," +
                " 1,\"Decouverte achéologiques egyptiennes\",\"Decouverte de fossiles\",\"Decouverte archéologiques africaines\"," +
                "\"Le verre  peut résister plus de 4000 ans, comme le prouvent certaines découvertes archéologiques.\"," +
                "\"On sait que le verre peut résister plus de 4 000 ans dans la nature grâce aux découvertes archéologiques égyptiennes.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",1," +
                "\"Combien de tonnes de déchets de plastiques flotteraient dans nos océans ?\"," +
                " 2,\"1 000 000 tonnes\",\"300 000 tonnes\",\"300 tonnes\"," +
                "\"Il y a plus de 300 tonnes de déchets qui flottent dans nos océans.\"," +
                "\"Près de 300 000 tonnes de déchets en plastique flotteraient dans nos océans. Ces résidus résistent pendant des centaines d'années et mettent ainsi en danger les écosystèmes.\");");

        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Au centre de tri, les emballages sont ?\"," +
                " 2,\"Séparés selon leur couleur\",\"Séparés manuellement et avec des machines par famille de matériaux\",\"Brûlés à l'arrivée\"," +
                "\"Attention question piège : L'emballage n'a pas de couleurs !\"," +
                "\"Les emballages sont séparés manuellement et avec des machines par famille de métal. @clubciteo.com\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Le recyclage est-il la meilleure solution ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Aucune idée\"," +
                "\"Le recyclage n'est pas encore optimal.\"," +
                "\"De nombreux produits que nous pensons être recyclables presque à l'infini ne le sont pas. Moins de 20 % de nos produits que nous pensons recyclables seront effectivement recyclés. Attention : les produits recyclables sont meilleurs que les non recyclables. Plus d'informations sur www.edeni.fr/comprendre-le-recyclage/pourquoi-il-ne-faut-pas-recycler/ .\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Qu'achète le recycleur ?\"," +
                " 1,\"Il achète des ballots d'emballages et de papiers triés\",\"Il achète des tas d'emballages\",\"Il achète des emballages non triés\"," +
                "\"Les déchets doivent être triés.\"," +
                "\"C'était la première réponse. @clubciteo.com.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Quelle méthode est à adopter avant de recycler ?\"," +
                " 3,\"Recycler-Réutiliser-Réduire-Décliner\",\"Réutiliser-Décliner-Réduire-Recycler\",\"Refuser-Réduire-Réutiliser-Recycler\"," +
                "\"Le processus de recyclage doit arriver à la fin.\"," +
                "\"Refuser ce qui n'est pas nécessaire (annonces commerciales, emballages à usage unique), Réduire ce dont nous avons besoin (éviter la surconsommation), Réutiliser/réparer ce que nous avons déjà\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"tri\",2," +
                "\"Qui est le premier maillon de la chaîne de tri ?\"," +
                " 2,\"Un opérateur au centre du tri\",\"Toi, en triant tes emballages\",\"Le ripper qui ramasse les bacs de tri\"," +
                "\"C'est juste après l'utilisation du produit.\"," +
                "\"Tu es le premier maillon de la chaîne de tri. @clubciteo.com\");");
    }

    public void insertClimateChange(SupportSQLiteDatabase db){
        //gulfStream 1 && 2 en online => 1 en local
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Quel est le Gulf Stream “courant du golf” ? Un courant océanique prenant sa source :\"," +
                " 1,\"Entre la Floride et les Bahamas\",\"Entre la Malaisie et l’Indonésie\",\"Entre le Groenland et l'Islande\"," +
                "\"Le Gulf Stream est un courant océanique qui prend sa source dans des eaux chaudes.\"," +
                "\"Le Gulf Stream est un courant océanique qui prend sa source entre la Floride et les Bahamas et se dilue dans l'océan Atlantique vers la longitude du Groenland. Le Gulf Stream joue un rôle dans la dérive nord atlantique qui désigne le mouvement lent des eaux chaudes de l’Atlantique grâce au Gulf stream vers le nord-est (Europe de l’Ouest) et l'océan Arctique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Est-ce que le réchauffement climatique pourrait faire accélérer le Gulf Stream ?\"," +
                " 2,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"Le Gulf Stream est impacté par le réchauffement climatique.\"," +
                "\"Les chercheurs du GIEC ont émis l'hypothèse que le réchauffement climatique pourrait provoquer l'arrêt de la circulation thermohaline, en raison de la diminution de la salinité et de l' augmentation de la température de l'océan Arctique. La circulation thermohaline participe à la redistribution de la chaleur dans le monde. Les scientifiques observent que le Gulf Stream ralentit en raison du changement climatique. Ainsi, il atteint ainsi son niveau le plus faible depuis un millénaire.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Qu'est ce que la circulation thermohaline ? La circulation océanique engendrée par :\"," +
                " 3,\"Les différences de températures de l’air\",\"Les différences de salinité dans l’eau\",\"Les différences de densité de l'eau de mer\"," +
                "\"Dans thermohaline, le terme thermo signifie température et halin signifie salinité.\"," +
                "\"La circulation thermohaline est la circulation océanique causée par des différences de densité de l’eau de mer. Ces différences de densité proviennent des différences de température et de salinité des masses d'eau, d'où les termes thermo pour température et halin pour salinité.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Qu'est ce qui pourrait arriver si le Gulf Stream se mettait à s'arrêter ?\"," +
                " 1,\"Climat glacial sur l’Europe\",\"Climat saharien sur l’Europe\",\"Climat saharien sur l’Amérique du Nord\"," +
                "\"L'arrêt du Gulf Stream pourrait entraîner une dépopulation de l’Europe.\"," +
                "\"Le Gulf Stream est en partie à l'origine du climat tempéré que l'on connaît dans l'ouest de l'Europe du nord. Or, cette circulation pourrait bien s'essouffler et engendrer un climat glacial sur l'Europe. Le Gulf Stream réchauffe l'Europe Occidentale, et favorise donc l'agriculture. Un effondrement de l'agriculture entraînerait une dépopulation de l'Europe.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Quel est un des éléments qui perturbe fortement le Gulf Stream parmi ces propositions ?\"," +
                " 2,\"Le réchauffement climatique\",\"La fonte des glaciers du Groenland\",\"La surpopulation\"," +
                "\"Le réchauffement climatique a pour conséquence la fonte des glaciers et ne perturbe pas directement le Gulf Stream.\"," +
                "\"En raison de l’impact combiné de la fonte du Groenland et de l’augmentation des précipitations, le Gulf Stream pourrait donc s’affaiblir et s’inverser dans les années à venir.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Est-ce que le Gulf Stream est en train de se décaler vers le Nord ?\"," +
                " 1,\"Vrai\",\"Faux\",\"Ne sais pas\"," +
                "\"Le décalage du Gulf Stream a pour conséquence d’apporter des températures plus chaudes au large des côtes nord-américaines.\"," +
                "\"Selon deux études parues dans “Nature”, le Gulf Stream ralentit et il serait en train de se décaler vers le Nord, avec pour conséquence des températures plus chaudes au large des côtes nord-américaines et plus froides au sud du Groenland.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Que veut dire l’AMOC ?\"," +
                " 2,\"Le courant marin de retournement Atlantique\",\"La circulation méridienne de retournement Atlantique\",\"La circulation méridienne de retournement Océanique\"," +
                "\"En anglais, l’AMOC signifie : The Atlantic Meridional Overturning Circulation.\"," +
                "\"La circulation méridienne de retournement de l'Atlantique (AMOC) est un vaste système de courants océaniques qui transportent l'eau chaude des tropiques vers le nord dans l'Atlantique Nord. Le Gulf Stream n'est que la partie en surface de l'AMOC dans l'Atlantique Nord.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Dans le film “The day after tomorrow”, une nouvelle ère glaciaire prend place causée par l’accélération du Gulf Stream ?\"," +
                " 3,\"Vrai\",\"Ne sais pas\",\"Faux\"," +
                "\"La probabilité d'un arrêt temporaire du Gulf Stream dans les 100 prochaines années serait d'environ 15 %\"," +
                "\"Il y a un risque de plus en plus préoccupant consistant à affirmer que l'AMOC puisse s'arrêter à un moment donné, faisant du film «The day after tomorrow» une réalité. Dans ce film, l'AMOC s’est arrêtée, amorçant une nouvelle ère glaciaire. Attention petit piège ^_^\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"En quelle année l'Europe a-t-elle connu le Petit Âge glaciaire ?\"," +
                " 1,\"Entre 1450 et 1850\",\"Au 21e siècle\",\"Au 15e siècle\"," +
                "\"L'Europe a connu 11 de ses 12 années les plus chaudes au 21e siècle.\"," +
                "\"Dans l’Histoire, Il y a 13.000 ans, l'AMOC s'était affaiblie, aboutissant à une chute des températures de 6°C au Groenland. Un autre ralentissement du Gulf Stream est en partie à l'origine du Petit Âge glaciaire (PAG) qu'a connu l'Europe entre 1450 et 1850.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",1," +
                "\"Quel est le pourcentage de chances/risques que le Gulf Stream s’arrête dans les 100 prochaines années ?\"," +
                " 2,\"50 %\",\"15 %\",\"90 %\"," +
                "\"Ce pourcentage a été obtenu grâce à une simulation et cet arrêt ne serait que temporaire.\"," +
                "\"Selon une nouvelle simulation, le courant de l'Atlantique Nord qui permet un climat relativement doux à l'Europe aurait 15% de risque qu’il s’arrête au cours des 100 prochaines années mais cet arrêt ne serait que temporaire.\");");

        // Canada chaleur & Fonte des glaces artiques
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Le 29 juin 2021, l’aéroport international de Portland au Nord-Ouest des Etats-Unis a enregistré un nouveau record de température de ?\"," +
                " 1,\"116 °F (46.7°C)\",\"121 °F (49.6°C)\",\"98 °F (36.7°C)\"," +
                "\"49,6 °C ont été enregistrés à Lytton (Canada) durant cette même période.\"," +
                "\"Le 23 juin 2021, les agences météorologiques ont annoncé une « vague de chaleur historique et dangereuse ». A Portland comme à Lytton, la normale pour juin est d’environ 20 °C ! Les experts n'ont pas hésité à parler de « la vague de chaleur la plus extrême que la Terre ait connue depuis longtemps ».\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Qu’est-ce qu’un dôme de chaleur ?\"," +
                " 2,\"L'air chaud est emprisonné par de faibles pressions, et en étant repoussé vers le sol, se réchauffe encore\",\"L'air chaud est emprisonné par de fortes pressions, et en étant repoussé vers le sol, se réchauffe encore.\",\"L'air chaud est emprisonné par de fortes pressions, et en étant repoussé vers le ciel, se réchauffe encore\"," +
                "\"Ce phénomène peut se comparer à comme si vous compressez de l’air dans un pneu de vélo, ça le réchauffe.\"," +
                "\"Le phénomène en jeu est appelé « dôme de chaleur ». L’air chaud est emprisonné par de fortes pressions, et en étant repoussé vers le sol, se réchauffe encore.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"30 juin 2021, 49,6 °C (121 °F) à Lytton au Canada, il n’a jamais fait aussi chaud à plus de 50° de latitude nord ?\"," +
                " 3,\"Faux\",\"Ne sais pas\",\"Vrai\"," +
                "\"C'est plus chaud que la température la plus élevée jamais enregistrée en Europe ou même en Amérique du Sud.\"," +
                "\"C'est plus chaud que la température la plus élevée jamais enregistrée en Europe ou même en Amérique du Sud. c'est une température stupéfiante de 49,6 °C qui a été enregistrée. Un record pour une ville située au-delà de 50° de latitude nord.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Le réchauffement climatique est la principale cause de cette forte vague de chaleur, il rend les vagues de chaleur ?\"," +
                " 1,\"plus fréquentes, plus longues, plus intenses\",\"plus fréquentes, plus courtes, plus intenses\",\"moins fréquentes, plus longues, plus intenses\"," +
                "\"Le réchauffement climatique rend le climat instable avec des vagues de chaleur de plus en plus fréquentes.\"," +
                "\"Selon les chercheurs, la question ne se pose plus. Le réchauffement climatique rend les vagues de chaleur plus fréquentes, plus longues et plus intenses.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Les vagues de chaleur se produisent combien de fois plus souvent que dans les années 1960 ?\"," +
                " 2,\"Cinq fois plus souvent\",\"Trois fois plus souvent\",\"Dix fois plus souvent\"," +
                "\"Les vagues de chaleur se produisent au moins trois fois plus souvent que dans les années 1960.\"," +
                "\"Les scientifiques le prédisent depuis longtemps. Les vagues de chaleur sont aujourd’hui trois fois plus fréquentes qu’elles ne l’étaient dans les années 1960. Elles touchent 25 % de superficies de plus dans l'hémisphère Nord qu'en 1980. Dans la région du nord-ouest du Pacifique touchée en fin juin 2021, les chercheurs annoncent un stress thermique qui triplera d'ici 2100.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"L’Arctique est une zone peu touchée par le réchauffement climatique anthropique par rapport à d'autres endroits de la Terre ?\"," +
                " 1,\"Faux\",\"Vrai\",\"Ne sais pas\"," +
                "\"La fonte de glace est particulièrement présente en Arctique.\"," +
                "\"L’Arctique est l’endroit le plus durement touché par le réchauffement climatique anthropique que partout ailleurs sur la Terre. Les autorités canadiennes ont décidé de classer “zone de protection marine” une région où la glace est la plus épaisse afin de servir de refuge pour les animaux.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Que signifie le terme “anthropique” dans “réchauffement climatique anthropique” ?\"," +
                " 2,\"D’origine animale.\",\"D’origine humaine.\",\"D’origine lointaine.\"," +
                "\"L'anthropologie est une science qui étudie l'être humain et les groupes humains sous tous leurs aspects, à la fois physiques et culturels.\"," +
                "\"Les causes de la pollution anthropique sont par exemple : les activités domestiques comme le chauffage, les activités industrielles, le transport routier ou non routier, l'agriculture, ...\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Des chercheurs étudient des régions de l’Arctique où les animaux vivants sur la glace pourraient s’y réfugier, comment s'appelle cette zone ?\"," +
                " 3,\"Toong-a-su-git\",\"Alianaigusukpunga takujunnarakkit!\",\"Tuvaijuittuq\"," +
                "\"La traduction de cette région en Inuktitut est : “l'endroit où la glace ne fond jamais”.\"," +
                "\"Les scientifiques estiment que c'est là que se trouve la banquise la plus ancienne et la plus épaisse de l'océan Arctique.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Certaines parties de la “dernière zone de glace” ont déjà commencé à décliner, le 14 août 2020 les images satellites ont montré un amincissement record de l'épaisseur de glace de ?\"," +
                " 1,\"50%\",\"70%\",\"20%\"," +
                "\"L'épaisseur de glace de mer au début de l'été était proche de la normale.\"," +
                "\"Le 16 août 2020, Polarstern, un brise-glace allemand, se trouvait dans la dernière zone de glace pour l’expédition Mosaic. Deux jours plus tôt, la concentration en glace mesurée n’était que de 50 % par rapport à celle habituelle.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",2," +
                "\"Le réchauffement climatique est-il le seul remis en cause dans la diminution des zones de glace en Arctique ?\"," +
                " 2,\"Oui, il fait fondre la glace.\",\"Non, des vents inhabituels peuvent se rajouter au réchauffement des températures.\",\"Oui, car il cause un dérèglement climatique.\"," +
                "\"Selon des chercheurs, seulement 20% de l’amincissement observé de la glace de mer est dû au réchauffement climatique.\"," +
                "\"A l’aide de données et de modèles satellitaires. Les chercheurs ont conclu que 80 % de l'amincissement observé étaient dus à des facteurs météorologiques. Par exemple, des vents inhabituels qui ont déplacé la glace de mer en dehors de la zone. Mais les 20% restants de l'amincissement de la banquise sont bien dus au réchauffement climatique.\");");

        //Amazon rainforest & weather forecast
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Quels sont les éléments qui ont participé à la réduction de la capacité à éliminer le dioxyde de carbone dans la forêt amazonienne ?\"," +
                " 1,\"Déforestation, incendies et réchauffement local rapide\",\"Déforestation, incendies et réchauffement global\",\"Déforestation et incendies\"," +
                "\"Les températures pendant la saison sèche ont gagné près de 3°C par rapport à l'ère pré-industrielle.\"," +
                "\"En raison du changement climatique et de la déforestation, une grande partie du bassin amazonien émet maintenant plus de CO2 qu’elle en absorbe, une transformation majeure pour cet écosystème crucial dans la limitation du réchauffement.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Quelle est la partie de la forêt amazonienne qui n’est plus un puits de carbone terrestre ?\"," +
                " 2,\"Nord-ouest\",\"Sud-Est\",\"Nord\"," +
                "\"Une partie de l'Amazonie est passée nettement d'un puits de carbone à une source de CO2.\"," +
                "\"L'équipe de recherche brésilienne a collecté 600 échantillons de CO2 et de monoxyde de carbone de 2010 à 2018. Selon leurs conclusions, la partie nord-ouest de l'Amazonie est à l'équilibre, absorbant autant de CO2 qu'elle en émet. Mais l'est (Sud-Est), surtout en saison sèche, est une source évidente.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Le changement climatique est un facteur clé dans la capacité à absorber le CO2, Les températures pendant la saison sèche ont gagné près de X°C par rapport à l’ère pré-industrielle ?\"," +
                " 3,\"5°C\",\"1.5°C\",\"3°C\"," +
                "\"+1.5°C, c’est le but à ne pas dépasser pour 2050 sur le réchauffement climatique global.\"," +
                "\"Parmi les causes de cette dégradation, les forêts brûlées pour faire place à l'élevage et à l'agriculture. Le changement climatique est également un facteur majeur: les températures pendant la saison sèche ont augmenté de près de 3°C par rapport à l’époque préindustrielle, soit presque trois fois plus que la moyenne mondiale.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Le dépérissement de la forêt amazonienne fait partie des points de bascule avec ?\"," +
                " 1,\"fonte des calottes glaciaires, dégel du permafrost, disparition des récifs coralliens …\",\"fonte des glaces, disparition des récifs coralliens …\",\"fonte des calottes glaciaires, disparition des récifs coralliens …\"," +
                "\"Ces points de bascule pourrait entraîner le système climatique vers un changement dramatique et irrémédiable.\"," +
                "\"Avec la fonte des calottes glaciaires, le dégel du permafrost, la disparition des récifs coralliens et le dépérissement de la forêt amazonienne. Ces éléments font partie des « points de bascule » identifiés par les scientifiques dont la modification substantielle pourrait entraîner le système climatique vers un changement dramatique et irrémédiable.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Parmi les quiz disponibles sur Environment Quiz, quel est le quiz parlant du permafrost ?\"," +
                " 2,\"Data Centers\",\"Svalbard Bunker végétal\",\"Plonge dans L’océan : Raja Ampat\"," +
                "\"Raja Ampat est un archipel situé en Indonésie.\"," +
                "\"Le quiz disponible parlant du permafrost est le quiz : “Svalbard Bunker Végétal”. Il est disponible dans les quiz de la semaine et sous la section : “👩‍🌾 culture 🌱”.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Les prévisions météorologiques font appel à de nombreux facteurs tels que ?\"," +
                " 1,\"Analyse des vents, de la pression atmosphérique, des températures, …\",\"Analyse des vents et des températures\",\"Analyse de la composition de l’air et des vents\"," +
                "\"Les prévisions météorologiques font appel à de nombreux facteurs.\"," +
                "\"Les prévisions météorologiques font appel à de nombreux facteurs : analyse des vents, de la pression atmosphérique, des températures, ...\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"A combien de semaine(s) d’avance peut-on prévoir une période de canicule ?\"," +
                " 2,\"Trois semaines\",\"Une semaine\",\"Cinq semaines\"," +
                "\"On peut dire plusieurs mois à l'avance si une saison sera plutôt chaude ou froide.\"," +
                "\"La prévision de la trajectoire d’une tornade est limitée à une dizaine de minutes. Alors que pour une tempête, c'est environ 3 jours à l'avance, une période de canicule environ une semaine, et on peut dire plusieurs mois à l'avance si une saison sera plutôt chaude ou froide\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"La manière d’établir des prévisions météorologiques à long terme s’améliore, on peut dire que la fiabilité de la prévision s’améliore de ?\"," +
                " 3,\"Cinq jours tous les 10 ans\",\"Trois jours tous les 10 ans\",\"Un jour tous les 10 ans\"," +
                "\"La fiabilité des prévisions à quatre jours aujourd'hui est équivalente à celle de trois jours il y a 10 ans.\"," +
                "\"Nous gagnons en moyenne un jour de prévision tous les 10 ans depuis les 30 dernières années. Cela signifie que la fiabilité des prévisions à quatre jours équivaut aujourd'hui à celle de trois jours il y a 10 ans et à deux jours il y a 20 ans.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Qu’est-ce que l’effet papillon en météorologie ?\"," +
                " 1,\"Un tout petit changement peut provoquer une énorme différence\",\"Une énorme différence peut provoquer un tout petit changement\",\"Les nuages montent dans le ciel\"," +
                "\"Il est très important à prendre en compte dans le processus de calcul des prévisions.\"," +
                "\"L'effet papillon à la base signifie qu'un tout petit changement de conditions au début peut provoquer une énorme différence en bout de ligne. C'est un peu le même principe en météorologie quand intervient le processus de calcul des prévisions.\");");
        db.execSQL("Insert into exotypeqcm (theme, niveau, question, positiongoodanswer, answer1, answer2, answer3, indice, explication) " +
                "VALUES(\"climatechange\",3," +
                "\"Qu’est-ce que la troposphère ?\"," +
                " 2,\"La couche supérieure de l'atmosphère\",\"La couche inférieure de l’atmosphère\",\"La couche d’air tropicale\"," +
                "\"Elle est présente sur des planètes comme la Terre, Mars ou Vénus\"," +
                "\"La troposphère est la couche inférieure de l'atmosphère. Elle est présente sur des planètes comme la Terre, Mars ou Vénus. Dans cette zone, les gaz sont retenus près du sol de la planète grâce à la gravité. La troposphère contient des nuages et la majeure partie de la vapeur d'eau de l'atmosphère. Elle est le siège d’évènements météorologiques (nuages, orages, etc).\");");


    }
}
