package com.momiouo.naturequiz.data.datasource.remote

import com.momiouo.naturequiz.domain.model.ArticleItem
import com.momiouo.naturequiz.domain.model.Question

object CuratedEnglishArticles {

    fun getArticles(): List<ArticleItem> = listOf(
        // ==========================================
        // 1. OCEANS (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_ocean_1",
            title = "Great Barrier Reef: Coral Larvae Seeding Shows Record Survival Rates",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/d41586-024-00100-w",
            summary = "Marine biologists have successfully seeded heat-tolerant coral larvae across damaged reef sections, observing accelerated calcification and resilience.",
            publishedDate = "Recent",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "What microscopic algae live symbiotically inside coral polyps to provide their food and vibrant colors?",
                    firstResponse = "Zooxanthellae",
                    secondResponse = "Cyanobacteria",
                    thirdResponse = "Spirulina",
                    correctAnswer = 1,
                    hint = "These photosynthetic dinoflagellates share energy directly with the coral host.",
                    explanation = "Zooxanthellae live inside coral tissues, providing up to 90% of the coral's energy via photosynthesis."
                ),
                Question(
                    question = "Off the coast of which country is the Great Barrier Reef located?",
                    firstResponse = "Australia",
                    secondResponse = "Brazil",
                    thirdResponse = "Madagascar",
                    correctAnswer = 1,
                    hint = "It stretches along the northeastern coast of this Pacific island-continent.",
                    explanation = "The Great Barrier Reef spans over 2,300 kilometers off the northeastern coast of Queensland, Australia."
                ),
                Question(
                    question = "What chemical phenomenon occurs when seawater absorbs excess atmospheric carbon dioxide?",
                    firstResponse = "Ocean acidification",
                    secondResponse = "Ocean evaporation",
                    thirdResponse = "Seawater desalination",
                    correctAnswer = 1,
                    hint = "CO2 dissolved in water forms carbonic acid, lowering ocean pH.",
                    explanation = "Ocean acidification reduces carbonate ions, making it harder for corals and mollusks to build calcium shells."
                ),
                Question(
                    question = "Approximately what percentage of all marine biodiversity relies on coral reef ecosystems?",
                    firstResponse = "Around 25%",
                    secondResponse = "Less than 1%",
                    thirdResponse = "Exactly 99%",
                    correctAnswer = 1,
                    hint = "Although covering under 1% of the seafloor, reefs shelter a quarter of all marine species.",
                    explanation = "Coral reefs are known as the rainforests of the sea, supporting roughly 25% of all known marine life."
                ),
                Question(
                    question = "At what critical water temperature threshold can corals expel their symbiotic algae, causing coral bleaching?",
                    firstResponse = "An increase of just 1 to 2 °C above summer maximums",
                    secondResponse = "A jump of at least 25 °C",
                    thirdResponse = "Only when water freezes to 0 °C",
                    correctAnswer = 1,
                    hint = "Corals are exceptionally sensitive to even slight prolonged temperature anomalies.",
                    explanation = "Prolonged thermal stress of just 1–2 °C above normal summer averages triggers coral bleaching."
                )
            )
        ),
        ArticleItem(
            id = "en_ocean_2",
            title = "Mariana Trench: Hydrothermal Vent Ecosystems Thriving in the Hadal Zone",
            sourceName = "Nature Geoscience",
            url = "https://www.nature.com/articles/s41561-024-01300-x",
            summary = "Deep-sea submersibles have mapped thriving microbial colonies at depths exceeding 10,000 meters, powered by mineral chemosynthesis.",
            publishedDate = "Recent",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "What is the approximate depth of the Challenger Deep in the Mariana Trench?",
                    firstResponse = "Nearly 11,000 meters",
                    secondResponse = "About 2,000 meters",
                    thirdResponse = "Over 45,000 meters",
                    correctAnswer = 1,
                    hint = "Mount Everest (8,848 m) could easily fit inside with kilometers of water to spare.",
                    explanation = "The Challenger Deep descends to approximately 10,928 meters below sea level in the western Pacific Ocean."
                ),
                Question(
                    question = "What biological process allows deep-sea organisms to produce organic matter without any sunlight?",
                    firstResponse = "Chemosynthesis",
                    secondResponse = "Photosynthesis",
                    thirdResponse = "Combustion",
                    correctAnswer = 1,
                    hint = "They extract chemical energy from mineral compounds like hydrogen sulfide.",
                    explanation = "Chemosynthetic bacteria use hydrogen sulfide and methane from hydrothermal vents to synthesize nutrients without sunlight."
                ),
                Question(
                    question = "What is the specialized ocean zone below 6,000 meters named after the underworld of mythology?",
                    firstResponse = "The Hadal zone",
                    secondResponse = "The Photic zone",
                    thirdResponse = "The Pelagic zone",
                    correctAnswer = 1,
                    hint = "The name is derived from Hades, the ancient Greek god of the underworld.",
                    explanation = "The Hadal zone encompasses the deepest trenches and troughs on Earth, starting from 6,000 meters down."
                ),
                Question(
                    question = "What extreme physical pressure do organisms endure at the bottom of the Mariana Trench?",
                    firstResponse = "Over 1,000 times atmospheric pressure at sea level",
                    secondResponse = "Exactly 2 times atmospheric pressure",
                    thirdResponse = "Zero pressure because water is weightless",
                    correctAnswer = 1,
                    hint = "Equivalent to having a heavy locomotive resting on every square centimeter of surface.",
                    explanation = "Water pressure at 11,000 meters exceeds 1,086 bar, or more than 1,000 times standard sea-level atmospheric pressure."
                ),
                Question(
                    question = "What mineral compound commonly forms the dark towering chimneys of deep-sea hydrothermal vents?",
                    firstResponse = "Polymetallic sulfides (iron, copper, zinc)",
                    secondResponse = "Pure calcium limestone",
                    thirdResponse = "Solid gold nuggets",
                    correctAnswer = 1,
                    hint = "Black smokers are built from precipitating metal sulfide minerals.",
                    explanation = "Black smokers form when mineral-rich hydrothermal fluids meet freezing ocean water, precipitating iron and copper sulfides."
                )
            )
        ),
        ArticleItem(
            id = "en_ocean_3",
            title = "Ocean Cleanups: Floating Barriers Remove Over 100 Tons of Waste from Pacific Gyre",
            sourceName = "National Geographic",
            url = "https://www.nationalgeographic.com/environment/article/ocean-plastic-cleanup-pacific",
            summary = "Autonomous floating retrieval vessels have cleared concentrated trash lines in the Great Pacific Garbage Patch, demonstrating effective offshore recovery.",
            publishedDate = "Recent",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "Between which two geographic locations is the Great Pacific Garbage Patch situated?",
                    firstResponse = "Between California and Hawaii",
                    secondResponse = "Between Greenland and Norway",
                    thirdResponse = "Between Madagascar and Antarctica",
                    correctAnswer = 1,
                    hint = "It sits in the North Pacific subtropical gyre between the US West Coast and the Hawaiian islands.",
                    explanation = "The largest ocean plastic accumulation zone rotates in the North Pacific subtropical gyre between California and Hawaii."
                ),
                Question(
                    question = "What term designates plastic debris fragmented into pieces smaller than 5 millimeters?",
                    firstResponse = "Microplastics",
                    secondResponse = "Nanofibers",
                    thirdResponse = "Macroplastics",
                    correctAnswer = 1,
                    hint = "The prefix signifies tiny microscopic or millimeter-scale debris.",
                    explanation = "Microplastics are defined as synthetic polymer fragments less than 5 mm in diameter, often ingested by marine fauna."
                ),
                Question(
                    question = "What primary physical force causes marine debris to concentrate in vast rotating ocean vortices?",
                    firstResponse = "Ocean gyres driven by wind and Earth's Coriolis effect",
                    secondResponse = "Underwater volcanic magnetism",
                    thirdResponse = "Moon gravitational pulls alone",
                    correctAnswer = 1,
                    hint = "Circular ocean current systems trap floating waste in their calm centers.",
                    explanation = "Subtropical ocean gyres are large rotating current systems that swirl floating debris inward into dense accumulation zones."
                ),
                Question(
                    question = "How many major oceanic gyres exist on planet Earth?",
                    firstResponse = "5 major subtropical gyres",
                    secondResponse = "Over 350 gyres",
                    thirdResponse = "Only 1 single gyre",
                    correctAnswer = 1,
                    hint = "There are two in the Pacific, two in the Atlantic, and one in the Indian Ocean.",
                    explanation = "Earth has 5 primary subtropical gyres: North Atlantic, South Atlantic, North Pacific, South Pacific, and Indian Ocean."
                ),
                Question(
                    question = "Approximately what percentage of waste floating in the Great Pacific Garbage Patch consists of discarded fishing gear?",
                    firstResponse = "Nearly 46% to 50%",
                    secondResponse = "Less than 0.1%",
                    thirdResponse = "Exactly 100%",
                    correctAnswer = 1,
                    hint = "Ghost nets, lines, and ropes from commercial fishing make up nearly half the floating mass.",
                    explanation = "Scientific surveys estimate that abandoned fishing nets and gear (ghost gear) constitute nearly half of the patch's total mass."
                )
            )
        ),
        ArticleItem(
            id = "en_ocean_4",
            title = "Blue Carbon: Seagrass Meadows Store Twice as Much Carbon per Hectare as Land Forests",
            sourceName = "Nature Climate Change",
            url = "https://www.nature.com/articles/s41558-024-01900-z",
            summary = "Global ecological mapping reveals that underwater seagrass beds trap organic sediments for millennia, forming one of the most durable carbon sinks.",
            publishedDate = "Recent",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "What is the term for organic carbon captured and stored naturally by coastal and marine ecosystems?",
                    firstResponse = "Blue Carbon",
                    secondResponse = "Green Nitrogen",
                    thirdResponse = "Brown Phosphorus",
                    correctAnswer = 1,
                    hint = "Named after the color of the oceans where this carbon is stored.",
                    explanation = "Blue carbon refers to carbon fixed and trapped by marine ecosystems like seagrasses, mangroves, and salt marshes."
                ),
                Question(
                    question = "What microscopic oceanic organisms produce over 50% of the oxygen in Earth's atmosphere?",
                    firstResponse = "Marine phytoplankton",
                    secondResponse = "Jellyfish",
                    thirdResponse = "Sea sponges",
                    correctAnswer = 1,
                    hint = "These drifting micro-algae perform massive photosynthesis near the ocean surface.",
                    explanation = "Phytoplankton, including diatoms and cyanobacteria, generate between 50% and 80% of Earth's oxygen."
                ),
                Question(
                    question = "Unlike terrestrial trees whose wood decomposes in decades, for how long can seagrass sediment trap carbon?",
                    firstResponse = "For centuries to thousands of years",
                    secondResponse = "For only 2 weeks",
                    thirdResponse = "No longer than 6 months",
                    correctAnswer = 1,
                    hint = "Oxygen-depleted underwater sediment prevents organic matter from decaying.",
                    explanation = "Anaerobic conditions in marine soil prevent bacterial decomposition, locking blue carbon for thousands of years."
                ),
                Question(
                    question = "Which endangered marine herbivore mammal feeds almost exclusively on seagrass meadows?",
                    firstResponse = "The Dugong (sea cow)",
                    secondResponse = "The Orca",
                    thirdResponse = "The Polar Bear",
                    correctAnswer = 1,
                    hint = "This gentle sirenian grazes shallow tropical coastal bays.",
                    explanation = "Dugongs and manatees are sirenian marine herbivores that rely directly on seagrass beds for sustenance."
                ),
                Question(
                    question = "What physical protection do dense coastal seagrass meadows provide to shorelines?",
                    firstResponse = "They dampen wave energy and prevent coastal erosion",
                    secondResponse = "They make seawater boil",
                    thirdResponse = "They eliminate ocean tides completely",
                    correctAnswer = 1,
                    hint = "Their dense leaf canopy slows current velocities and binds sand.",
                    explanation = "Seagrasses dissipate up to 40% of wave energy, stabilizing sediments and preventing coastal erosion."
                )
            )
        ),
        ArticleItem(
            id = "en_ocean_5",
            title = "The Whale Pump: How Migrating Ocean Giants Fertilize Marine Life with Iron",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.ade0100",
            summary = "Biologists have quantified the nutrient cycle of baleen whales, showing how surface defecation delivers essential iron that stimulates phytoplankton blooms.",
            publishedDate = "Recent",
            themeTag = "oceans",
            curatedQuestions = listOf(
                Question(
                    question = "What is the biological phenomenon called where deep-feeding whales release iron-rich nutrients at the surface?",
                    firstResponse = "The whale pump",
                    secondResponse = "The coral elevator",
                    thirdResponse = "The cetacean geyser",
                    correctAnswer = 1,
                    hint = "It functions like an organic vertical elevator for oceanic nutrients.",
                    explanation = "The whale pump describes how whales feed at depth and release iron and nitrogen at the sunlit surface."
                ),
                Question(
                    question = "What tiny shrimp-like crustacean forms the primary diet of Antarctic blue whales and humpbacks?",
                    firstResponse = "Krill",
                    secondResponse = "Sea cucumbers",
                    thirdResponse = "Barnacles",
                    correctAnswer = 1,
                    hint = "Euphausia superba swarms in billions in cold Southern Ocean waters.",
                    explanation = "Antarctic krill forms the cornerstone of the Southern Ocean food web, sustaining baleen whales, seals, and penguins."
                ),
                Question(
                    question = "What physical feeding structure do baleen whales possess instead of teeth?",
                    firstResponse = "Baleen plates made of keratin",
                    secondResponse = "Limestone dental rasps",
                    thirdResponse = "Metal cartilage",
                    correctAnswer = 1,
                    hint = "It is made of the same protein found in human hair and fingernails.",
                    explanation = "Baleen plates are keratinous comb-like structures suspended from the upper jaw used to filter krill and small fish."
                ),
                Question(
                    question = "Which is the largest animal known ever to have existed on Earth?",
                    firstResponse = "The Blue Whale",
                    secondResponse = "The Megalodon",
                    thirdResponse = "The Tyrannosaurus Rex",
                    correctAnswer = 1,
                    hint = "It can reach lengths of 30 meters and weigh up to 190 metric tons.",
                    explanation = "The blue whale (Balaenoptera musculus) is the heaviest and largest animal known, surpassing even the largest dinosaurs."
                ),
                Question(
                    question = "How much carbon can a single large whale sequester over its lifetime before sinking to the seafloor upon natural death?",
                    firstResponse = "Around 33 tons of carbon dioxide equivalent",
                    secondResponse = "Less than 10 grams",
                    thirdResponse = "Over 100,000 tons",
                    correctAnswer = 1,
                    hint = "Equivalent to the annual carbon capture of thousands of mature trees.",
                    explanation = "An average large whale locks about 33 tons of carbon in its carcass, taking it down to the deep seafloor for centuries."
                )
            )
        ),

        // ==========================================
        // 2. ANIMALS & WILDLIFE (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_animal_1",
            title = "Iberian Lynx Recovery: Population Rebounds Past 2,000 Individuals in Spain and Portugal",
            sourceName = "National Geographic",
            url = "https://www.nationalgeographic.com/animals/article/iberian-lynx-population-recovery",
            summary = "Conservation breeding programs and rabbit habitat restoration have allowed the world's most endangered feline to rebound from just 94 individuals in 2002.",
            publishedDate = "Recent",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "What small mammal makes up over 80% of the natural diet of the Iberian lynx?",
                    firstResponse = "The European wild rabbit",
                    secondResponse = "The fruit bat",
                    thirdResponse = "The brown trout",
                    correctAnswer = 1,
                    hint = "The collapse of this burrowing mammal caused the lynx population crash.",
                    explanation = "The European rabbit (Oryctolagus cuniculus) is the essential prey of the Iberian lynx, which struggles to hunt larger quarry."
                ),
                Question(
                    question = "On which European peninsula is the native habitat of the Iberian lynx found?",
                    firstResponse = "The Iberian Peninsula (Spain & Portugal)",
                    secondResponse = "The Scandinavian Peninsula",
                    thirdResponse = "The Balkan Peninsula",
                    correctAnswer = 1,
                    hint = "Named after the historic Latin name for the Spanish and Portuguese territories.",
                    explanation = "The Iberian lynx is endemic to the Mediterranean scrubland of southern and central Spain and Portugal."
                ),
                Question(
                    question = "What distinctive physical feature marks the tips of a lynx's ears?",
                    firstResponse = "Black tufts of stiff hair",
                    secondResponse = "Feathered plumes",
                    thirdResponse = "Spiral cartilage horns",
                    correctAnswer = 1,
                    hint = "These prominent pointed tufts help locate subtle sounds in dense underbrush.",
                    explanation = "Lynx have characteristic black hair tufts on their ear tips that aid acoustic sensitivity and communication."
                ),
                Question(
                    question = "What conservation status change did the IUCN award the Iberian lynx in 2024 following population surges?",
                    firstResponse = "Downlisted from Endangered to Vulnerable",
                    secondResponse = "Declared completely extinct",
                    thirdResponse = "Classified as an invasive pest",
                    correctAnswer = 1,
                    hint = "A historic milestone reflecting twenty years of coordinated wildlife rescue.",
                    explanation = "In 2024, the IUCN officially upgraded the Iberian lynx status from Endangered to Vulnerable as numbers passed 2,000."
                ),
                Question(
                    question = "What infrastructure solution allows wild predators like the lynx to cross busy highways safely?",
                    firstResponse = "Vegetated wildlife overpasses (ecoducts)",
                    secondResponse = "Underground elevator shafts",
                    thirdResponse = "Helicopter transport cages",
                    correctAnswer = 1,
                    hint = "Green bridges built across motorways connect fragmented forest territories.",
                    explanation = "Ecoducts and wildlife crossings restore ecological corridors, dramatically cutting vehicle collision mortality."
                )
            )
        ),
        ArticleItem(
            id = "en_animal_2",
            title = "Monarch Butterfly Migration: Satellite Trackers Reveal 4,000 km Intercontinental Feat",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/d41586-024-00210-y",
            summary = "Micro-sensor telemetry reveals the multi-generational navigation system guiding millions of monarchs from southern Canada to Mexican mountain fir forests.",
            publishedDate = "Recent",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "What single host plant is strictly required by monarch caterpillars for food and development?",
                    firstResponse = "Milkweed (Asclepias)",
                    secondResponse = "Oak leaves",
                    thirdResponse = "Clover",
                    correctAnswer = 1,
                    hint = "The plant produces a milky latex containing cardenolides that make monarchs toxic to birds.",
                    explanation = "Monarch butterflies lay eggs exclusively on milkweed plants, which caterpillars feed on to absorb defensive toxins."
                ),
                Question(
                    question = "In which high-altitude mountain forests in central Mexico do millions of monarchs gather each winter?",
                    firstResponse = "Oyamel fir forests",
                    secondResponse = "Amazonian palm groves",
                    thirdResponse = "Saharan cactus valleys",
                    correctAnswer = 1,
                    hint = "These cool, misty evergreen fir trees provide ideal microclimates for hibernation.",
                    explanation = "Monarchs overwinter clustered on Oyamel fir trees (Abies religiosa) in the mountains of Michoacán, Mexico."
                ),
                Question(
                    question = "How many successive generations does it take for monarchs to complete their full annual migration cycle?",
                    firstResponse = "3 to 4 generations",
                    secondResponse = "Only 1 single insect",
                    thirdResponse = "Over 100 generations",
                    correctAnswer = 1,
                    hint = "The migrating 'super-generation' lives up to 8 months, while summer generations live just a few weeks.",
                    explanation = "The migration requires 4 generations: the fourth generation lives 8 months and migrates all the way south to Mexico."
                ),
                Question(
                    question = "What sensory navigation mechanism do monarchs use to maintain their southward compass bearing?",
                    firstResponse = "A time-compensated sun compass in their antennae and eyes",
                    secondResponse = "Sonar sound waves like dolphins",
                    thirdResponse = "Following scent trails left on trees",
                    correctAnswer = 1,
                    hint = "They combine the position of the sun with an internal circadian clock in their antennae.",
                    explanation = "Monarchs calculate heading using polarized sunlight and an internal circadian clock located in their antennae."
                ),
                Question(
                    question = "What warning coloration strategy do monarchs use with their vibrant orange and black wings?",
                    firstResponse = "Aposematism (warning coloration signaling toxicity)",
                    secondResponse = "Crypsis (transparent camouflage)",
                    thirdResponse = "Bioluminescence (emitting light in darkness)",
                    correctAnswer = 1,
                    hint = "Bright colors warn predators that the insect tastes bitter and poisonous.",
                    explanation = "Aposematism is the evolutionary adaptation where bright contrasting patterns advertise bad taste or toxicity to predators."
                )
            )
        ),
        ArticleItem(
            id = "en_animal_3",
            title = "Honeybee Waggle Dance: Decoded Mathematics of Colony Navigation and Foraging",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.abf0300",
            summary = "High-speed infrared cameras analyze how scout bees translate the angle of the sun and distance into rhythmic body vibrations inside dark hives.",
            publishedDate = "Recent",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "Which Nobel Prize-winning ethologist first cracked the code of the honeybee waggle dance in 1944?",
                    firstResponse = "Karl von Frisch",
                    secondResponse = "Charles Darwin",
                    thirdResponse = "Jane Goodall",
                    correctAnswer = 1,
                    hint = "An Austrian biologist who dedicated his life to researching bee senses.",
                    explanation = "Karl von Frisch decoded the waggle dance, demonstrating that bees communicate angles relative to the sun and flight distance."
                ),
                Question(
                    question = "Approximately what proportion of global human food crops rely directly on insect pollination?",
                    firstResponse = "About 75% of leading food crops",
                    secondResponse = "Less than 2%",
                    thirdResponse = "Exactly 100%",
                    correctAnswer = 1,
                    hint = "Nearly three-quarters of all fruits, vegetables, seeds, and nuts depend on pollinators.",
                    explanation = "The UN FAO notes that 75% of crops producing fruits or seeds for human food depend at least in part on pollinators."
                ),
                Question(
                    question = "What two valuable floral resources do worker bees collect from flowers?",
                    firstResponse = "Nectar (carbohydrates) and pollen (proteins)",
                    secondResponse = "Chlorophyll and tree bark",
                    thirdResponse = "Pure oxygen and nitrogen gas",
                    correctAnswer = 1,
                    hint = "One is a sweet sugary liquid; the other is fine protein powder.",
                    explanation = "Bees collect carbohydrate-rich nectar to produce honey and protein-rich pollen to feed developing larvae."
                ),
                Question(
                    question = "How do scout bees communicate the distance to a flower patch during the waggle dance?",
                    firstResponse = "By the duration of the waggle run vibration",
                    secondResponse = "By buzzing at a higher pitch",
                    thirdResponse = "By flapping their wings backward",
                    correctAnswer = 1,
                    hint = "Every second of waggle vibration represents roughly one kilometer of flight distance.",
                    explanation = "The duration of the waggle phase correlates directly with distance: one second corresponds to approximately 1,000 meters."
                ),
                Question(
                    question = "What class of widely used synthetic pesticides has been proven to impair bee navigation and memory?",
                    firstResponse = "Neonicotinoids",
                    secondResponse = "Table salt",
                    thirdResponse = "Baking soda",
                    correctAnswer = 1,
                    hint = "Chemical neurotoxins structurally related to nicotine that target insect nervous systems.",
                    explanation = "Neonicotinoids act on insect acetylcholine receptors, disorienting honeybees and causing colony collapse disorder."
                )
            )
        ),
        ArticleItem(
            id = "en_animal_4",
            title = "Wolf Reintroduction in Yellowstone: How Apex Predators Reshaped River Systems",
            sourceName = "National Geographic",
            url = "https://www.nationalgeographic.com/animals/article/yellowstone-wolves-trophic-cascade",
            summary = "Thirty years after grey wolves returned to Yellowstone National Park, researchers document a classic trophic cascade stabilizing riverbanks and restoring willow canopies.",
            publishedDate = "Recent",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "What ecological term describes the top-down chain reaction triggered across an ecosystem when an apex predator returns?",
                    firstResponse = "A trophic cascade",
                    secondResponse = "Genetic drift",
                    thirdResponse = "Soil salinization",
                    correctAnswer = 1,
                    hint = "A cascading effect flowing down the ecological food chain from predators to plants.",
                    explanation = "A trophic cascade occurs when predators suppress the abundance or alter the behavior of prey, releasing lower trophic levels."
                ),
                Question(
                    question = "By hunting and displacing large herds of elk, what trees did wolves allow to regenerate along Yellowstone riverbanks?",
                    firstResponse = "Willows and aspens",
                    secondResponse = "Cactus plants",
                    thirdResponse = "Giant redwoods",
                    correctAnswer = 1,
                    hint = "These slender deciduous trees flourish near rivers and are favored food for beavers.",
                    explanation = "Regrowing willows and cottonwoods shaded trout streams and provided food and building materials for beaver colonies."
                ),
                Question(
                    question = "What semi-aquatic rodent returned in large numbers once willows recovered, building dams that stabilized water tables?",
                    firstResponse = "The North American Beaver",
                    secondResponse = "The Grey Squirrel",
                    thirdResponse = "The Prairie Dog",
                    correctAnswer = 1,
                    hint = "Famous for building lodges and dams across running creeks.",
                    explanation = "Beavers returned to Yellowstone river systems, creating wetland ponds that slowed water flow and boosted amphibian diversity."
                ),
                Question(
                    question = "In what year were grey wolves officially reintroduced into Yellowstone National Park after a 70-year absence?",
                    firstResponse = "1995",
                    secondResponse = "1812",
                    thirdResponse = "2021",
                    correctAnswer = 1,
                    hint = "Fourteen wolves were brought from Alberta, Canada in the mid-1990s.",
                    explanation = "In 1995, 14 Canadian wolves were released into Yellowstone, restoring a natural balance missing since the 1920s."
                ),
                Question(
                    question = "What biological definition applies to wolves because their presence exerts disproportionate influence over ecosystem health?",
                    firstResponse = "Keystone species",
                    secondResponse = "Invasive alien species",
                    thirdResponse = "Primary producer",
                    correctAnswer = 1,
                    hint = "Named after the central wedge-shaped stone that locks an architectural arch together.",
                    explanation = "A keystone species has an outsized effect on its natural environment relative to its numerical abundance."
                )
            )
        ),
        ArticleItem(
            id = "en_animal_5",
            title = "Snow Leopard Telemetry: Camera Traps Reveal High Himalayan Density Above 4,000 Meters",
            sourceName = "Nature Ecology & Evolution",
            url = "https://www.nature.com/articles/s41559-024-02300-4",
            summary = "AI-powered camera trap networks in Tibet and Ladakh uncover resilient snow leopard populations adapted to oxygen-sparse alpine ridges.",
            publishedDate = "Recent",
            themeTag = "animaux",
            curatedQuestions = listOf(
                Question(
                    question = "What anatomical adaptation allows snow leopards to breathe efficiently in the thin air of high mountains?",
                    firstResponse = "Unusually wide nasal cavities and an enlarged chest cavity",
                    secondResponse = "Fish-like gills on their neck",
                    thirdResponse = "Hollow bones like birds",
                    correctAnswer = 1,
                    hint = "Wide nasal passages warm and humidify cold, oxygen-sparse mountain air.",
                    explanation = "Snow leopards have wide nasal cavities and high red blood cell counts to extract oxygen from thin alpine atmospheres."
                ),
                Question(
                    question = "What physical function does the snow leopard's exceptionally long, thick tail serve?",
                    firstResponse = "It aids balance on cliffs and wraps around the face for warmth while resting",
                    secondResponse = "It is used to swat fish out of rivers",
                    thirdResponse = "It stores drinking water",
                    correctAnswer = 1,
                    hint = "A versatile furry appendage used like a balancing pole and a warm scarf.",
                    explanation = "The tail, nearly as long as the body, provides agility on steep scree and wraps over the nose to prevent frostbite."
                ),
                Question(
                    question = "What wild mountain ungulate forms the primary natural prey of snow leopards in the Himalayas?",
                    firstResponse = "The blue sheep (Bharal) and Asiatic ibex",
                    secondResponse = "The African gazelle",
                    thirdResponse = "The wild turkey",
                    correctAnswer = 1,
                    hint = "Agile cliff-dwelling wild caprids with backward-curved horns.",
                    explanation = "The blue sheep (Pseudois nayaur) and ibex are the primary wild prey sustaining snow leopards across Central Asia."
                ),
                Question(
                    question = "What solitary behavior earned the snow leopard the poetic moniker 'Ghost of the Mountains'?",
                    firstResponse = "Its reclusive stealth and near-perfect rock camouflage",
                    secondResponse = "It is completely transparent in daylight",
                    thirdResponse = "It can fly without making sound",
                    correctAnswer = 1,
                    hint = "Its smoky grey rosette-patterned coat blends seamlessly with granite cliffs.",
                    explanation = "The snow leopard's smoky grey coat, quiet solitary movement, and inaccessible habitat make it extremely difficult to spot."
                ),
                Question(
                    question = "Across how many sovereign Asian countries does the snow leopard's high mountain range extend?",
                    firstResponse = "12 countries (including India, China, Nepal, Mongolia)",
                    secondResponse = "Only 1 single country",
                    thirdResponse = "Over 90 countries",
                    correctAnswer = 1,
                    hint = "A vast transboundary range encompassing the Himalayas, Karakoram, and Altai mountains.",
                    explanation = "Snow leopards inhabit the high mountain ranges of 12 Asian countries across Central and South Asia."
                )
            )
        ),

        // ==========================================
        // 3. CLEAN ENERGY (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_energy_1",
            title = "Perovskite Tandem Solar Cells: Laboratory Prototypes Surpass 33% Efficiency Record",
            sourceName = "Nature Energy",
            url = "https://www.nature.com/articles/s41560-024-01450-w",
            summary = "Layering synthetic perovskite crystals over traditional silicon wafers captures both blue and red light spectra, shattering standard silicon thermodynamic limits.",
            publishedDate = "Recent",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "What mineral crystalline structure is named after Russian mineralogist L. A. Perovski?",
                    firstResponse = "Perovskite (ABX3 crystal lattice)",
                    secondResponse = "Granite",
                    thirdResponse = "Basalt",
                    correctAnswer = 1,
                    hint = "Known for its unique cubic lattice that absorbs high-energy photons exceptionally well.",
                    explanation = "Perovskite materials share the ABX3 crystal structure, offering tunable bandgaps ideal for absorbing sunlight."
                ),
                Question(
                    question = "What is the theoretical physical efficiency limit for single-junction silicon solar cells?",
                    firstResponse = "The Shockley-Queisser limit (approx. 33.7%)",
                    secondResponse = "Exactly 100%",
                    thirdResponse = "No more than 5%",
                    correctAnswer = 1,
                    hint = "Formulated in 1961 based on bandgap thermodynamic losses.",
                    explanation = "The Shockley-Queisser limit caps single p-n junction silicon solar cells at roughly 33.7% maximum solar conversion."
                ),
                Question(
                    question = "How does a tandem solar cell achieve higher efficiency than a single silicon layer?",
                    firstResponse = "By stacking two materials that each absorb different wavelengths of the light spectrum",
                    secondResponse = "By heating water to 1,000 °C",
                    thirdResponse = "By reflecting all light into space",
                    correctAnswer = 1,
                    hint = "Perovskite catches blue/green high-energy light; silicon underneath absorbs red/infrared photons.",
                    explanation = "Tandem cells stack perovskite over silicon: the top layer captures short wavelengths, while silicon absorbs longer infrared light."
                ),
                Question(
                    question = "Which French physicist first observed the photovoltaic effect in an electrolytic cell in 1839?",
                    firstResponse = "Alexandre-Edmond Becquerel",
                    secondResponse = "Louis Pasteur",
                    thirdResponse = "Albert Einstein",
                    correctAnswer = 1,
                    hint = "He discovered electricity generation from light when he was just 19 years old.",
                    explanation = "Edmond Becquerel discovered the photovoltaic effect in 1839 while experimenting with platinum electrodes coated with silver halide."
                ),
                Question(
                    question = "What common semiconductor element makes up over 90% of all solar panels installed worldwide today?",
                    firstResponse = "Silicon (Si)",
                    secondResponse = "Lead (Pb)",
                    thirdResponse = "Uranium (U)",
                    correctAnswer = 1,
                    hint = "The second most abundant element in Earth's crust after oxygen, refined from quartz sand.",
                    explanation = "Crystalline silicon remains the dominant photovoltaic material globally thanks to mature manufacturing and high stability."
                )
            )
        ),
        ArticleItem(
            id = "en_energy_2",
            title = "Floating Offshore Wind: Deep-Water Megawatt Turbines Installed in Ocean Gaps",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/d41586-024-00400-1",
            summary = "Moored by heavy synthetic tethers in depths over 100 meters, next-generation 15-megawatt floating turbines harness steady oceanic gales.",
            publishedDate = "Recent",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "How are floating wind turbine platforms held in place in deep ocean waters?",
                    firstResponse = "By heavy mooring lines and anchors fastened to the seabed",
                    secondResponse = "By underwater jet engines",
                    thirdResponse = "By magnets attracted to the Earth's core",
                    correctAnswer = 1,
                    hint = "Similar to offshore oil platform tension tethers anchored into deep sediment.",
                    explanation = "Floating turbines use semi-submersible, spar, or tension-leg platforms held steady by heavy seabed mooring cables."
                ),
                Question(
                    question = "Why are ocean winds generally far more advantageous for power generation than onshore winds?",
                    firstResponse = "Ocean winds are stronger, smoother, and much more consistent due to zero terrain friction",
                    secondResponse = "Wind over water contains no air molecules",
                    thirdResponse = "Ocean winds blow only during the night",
                    correctAnswer = 1,
                    hint = "The flat sea surface offers zero obstacles like hills, trees, or tall city buildings.",
                    explanation = "Open ocean winds blow faster and more reliably with higher capacity factors (often exceeding 50%)."
                ),
                Question(
                    question = "How many megawatts (MW) are equivalent to one gigawatt (GW) of renewable capacity?",
                    firstResponse = "1,000 MW",
                    secondResponse = "10 MW",
                    thirdResponse = "1,000,000 MW",
                    correctAnswer = 1,
                    hint = "Standard SI metric prefix progression from kilo to mega to giga.",
                    explanation = "One gigawatt equals 1,000 megawatts, or one billion watts of power capacity."
                ),
                Question(
                    question = "What physical principle allows aerodynamic wind turbine blades to spin and drive the generator?",
                    firstResponse = "Aerodynamic lift created by asymmetrical airfoils",
                    secondResponse = "Steam propulsion",
                    thirdResponse = "Centrifugal gravity attraction",
                    correctAnswer = 1,
                    hint = "The exact same fluid mechanics principle that allows airplane wings to fly.",
                    explanation = "Wind turbine blades are curved airfoils: air flows faster over the curved top, creating pressure differences and aerodynamic lift."
                ),
                Question(
                    question = "In which European body of water are some of the world's largest commercial offshore wind farms situated?",
                    firstResponse = "The North Sea",
                    secondResponse = "The Black Sea",
                    thirdResponse = "The Caspian Sea",
                    correctAnswer = 1,
                    hint = "A shallow sea bordered by the UK, Netherlands, Germany, Denmark, and Norway.",
                    explanation = "The North Sea boasts prime shallow bathymetry and constant gale winds, hosting massive wind installations like Dogger Bank."
                )
            )
        ),
        ArticleItem(
            id = "en_energy_3",
            title = "Green Hydrogen: Megawatt Proton Exchange Membrane Electrolyzers Reach Industrial Scale",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.ade0500",
            summary = "Utilizing surplus solar and wind power, industrial PEM electrolyzers split pure water molecules into hydrogen and oxygen with zero carbon emissions.",
            publishedDate = "Recent",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "What chemical reaction occurs during the electrolysis of water?",
                    firstResponse = "2 H2O -> 2 H2 + O2",
                    secondResponse = "CO2 + H2O -> C6H12O6",
                    thirdResponse = "CH4 + 2 O2 -> CO2 + 2 H2O",
                    correctAnswer = 1,
                    hint = "Electrical current splits liquid water molecules into gaseous hydrogen and oxygen.",
                    explanation = "Electrolysis splits water into molecular hydrogen gas (H2) and molecular oxygen gas (O2) without creating carbon dioxide."
                ),
                Question(
                    question = "What distinguishes 'green hydrogen' from conventional 'grey hydrogen'?",
                    firstResponse = "Green hydrogen is made from water using 100% renewable electricity",
                    secondResponse = "Green hydrogen is dyed green with plant chlorophyll",
                    thirdResponse = "Green hydrogen is extracted from coal mines",
                    correctAnswer = 1,
                    hint = "Grey hydrogen is produced from fossil natural gas via steam reforming, emitting large amounts of CO2.",
                    explanation = "Green hydrogen uses renewable electricity (wind/solar) to power electrolysis, emitting zero greenhouse gases during production."
                ),
                Question(
                    question = "What is the only chemical byproduct emitted when hydrogen is consumed in a fuel cell?",
                    firstResponse = "Pure water vapor (H2O)",
                    secondResponse = "Carbon soot",
                    thirdResponse = "Sulfur dioxide",
                    correctAnswer = 1,
                    hint = "Hydrogen combines with atmospheric oxygen to release electricity and water.",
                    explanation = "In a hydrogen fuel cell, hydrogen and oxygen combine electrochemically, producing electric current and pure clean water."
                ),
                Question(
                    question = "What precious noble metal is widely used as a catalyst on the cathode of PEM electrolyzers?",
                    firstResponse = "Platinum",
                    secondResponse = "Aluminum",
                    thirdResponse = "Lead",
                    correctAnswer = 1,
                    hint = "A dense, silvery-white precious metal resistant to acid corrosion.",
                    explanation = "Platinum is the benchmark catalyst for the hydrogen evolution reaction in acidic proton exchange membrane (PEM) cells."
                ),
                Question(
                    question = "Which heavy industrial sector could be decarbonized by replacing coking coal with green hydrogen?",
                    firstResponse = "Steelmaking (Direct Reduced Iron)",
                    secondResponse = "Plastic toy painting",
                    thirdResponse = "Wood furniture carving",
                    correctAnswer = 1,
                    hint = "Using hydrogen as a reducing agent removes oxygen from iron ore, releasing water instead of CO2.",
                    explanation = "Green hydrogen can replace coal in steel production (DRI technology), which currently accounts for 7% of global carbon emissions."
                )
            )
        ),
        ArticleItem(
            id = "en_energy_4",
            title = "Enhanced Geothermal Systems: Closed-Loop Wells Extract Clean Heat from 5 km Underground",
            sourceName = "Scientific American",
            url = "https://www.scientificamerican.com/article/next-gen-geothermal-energy-breakthrough",
            summary = "Horizontal directional drilling adopted from oil tech allows closed-loop fluid circulation through hot dry bedrock, delivering 24/7 baseload renewable electricity.",
            publishedDate = "Recent",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "What is the primary thermodynamic heat source driving Earth's internal geothermal energy?",
                    firstResponse = "Radioactive decay of isotopes (uranium, thorium, potassium) and primordial formation heat",
                    secondResponse = "Solar rays penetrating to the core",
                    thirdResponse = "Ocean water friction against the seabed",
                    correctAnswer = 1,
                    hint = "Decaying heavy atoms in Earth's mantle and core maintain temperatures exceeding 5,000 °C.",
                    explanation = "Roughly 50% of Earth's internal heat comes from the radioactive decay of long-lived isotopes, with the rest from primordial accretion heat."
                ),
                Question(
                    question = "Which volcanic island nation heats over 90% of its homes using direct geothermal energy?",
                    firstResponse = "Iceland",
                    secondResponse = "Australia",
                    thirdResponse = "Ireland",
                    correctAnswer = 1,
                    hint = "Situated directly over the Mid-Atlantic Ridge hot spot.",
                    explanation = "Iceland relies on abundant volcanic geothermal fields for district heating in 90% of buildings and roughly 30% of its electricity."
                ),
                Question(
                    question = "What major advantage does geothermal power have over solar and wind power?",
                    firstResponse = "It provides 24/7 continuous baseload power regardless of weather or sunlight",
                    secondResponse = "It produces pure drinking oil",
                    thirdResponse = "It requires no underground piping",
                    correctAnswer = 1,
                    hint = "It runs constantly day and night, unhindered by cloud cover or calm wind conditions.",
                    explanation = "Geothermal is a non-intermittent, reliable baseload source that operates continuously around the clock."
                ),
                Question(
                    question = "What is the average geothermal gradient (temperature rise) as you dig deeper into Earth's continental crust?",
                    firstResponse = "Roughly 25 to 30 °C per kilometer of depth",
                    secondResponse = "Less than 0.001 °C per kilometer",
                    thirdResponse = "Over 1,000 °C every single meter",
                    correctAnswer = 1,
                    hint = "A five-kilometer well can tap rock temperatures of 150 °C to 200 °C.",
                    explanation = "In typical continental crust, rock temperatures increase by approximately 25–30 °C for every kilometer of depth."
                ),
                Question(
                    question = "What type of closed-loop turbine system evaporates low-boiling organic fluids using moderate geothermal water temperatures?",
                    firstResponse = "An Organic Rankine Cycle (ORC) plant",
                    secondResponse = "A coal furnace",
                    thirdResponse = "A nuclear fission reactor",
                    correctAnswer = 1,
                    hint = "It uses fluids with lower boiling points than water (such as isobutane) to spin turbines.",
                    explanation = "Binary Organic Rankine Cycle plants generate power from warm geothermal brine as cool as 100 °C by boiling organic working fluids."
                )
            )
        ),
        ArticleItem(
            id = "en_energy_5",
            title = "Solid-State Batteries: Ceramic Electrolytes Double Driving Range for Electric Vehicles",
            sourceName = "Nature Materials",
            url = "https://www.nature.com/articles/s41563-024-01820-2",
            summary = "Replacing volatile liquid organic electrolytes with solid lithium-conducting ceramics prevents dendrite short-circuits and unlocks ultra-fast charging.",
            publishedDate = "Recent",
            themeTag = "energies",
            curatedQuestions = listOf(
                Question(
                    question = "What fundamental component is replaced in a solid-state battery compared to a standard lithium-ion cell?",
                    firstResponse = "The flammable liquid electrolyte is replaced with a solid electrolyte (ceramic or polymer)",
                    secondResponse = "The metal casing is replaced with wood",
                    thirdResponse = "Electricity is replaced with gasoline",
                    correctAnswer = 1,
                    hint = "The ion-conducting medium between anode and cathode is made solid instead of liquid.",
                    explanation = "Solid-state batteries replace volatile liquid solvent electrolytes with non-flammable solid ceramic or polymer ion conductors."
                ),
                Question(
                    question = "What microscopic lithium needle-like structures can pierce separators in liquid batteries, causing dangerous short-circuits?",
                    firstResponse = "Dendrites",
                    secondResponse = "Coral reefs",
                    thirdResponse = "Graphite pearls",
                    correctAnswer = 1,
                    hint = "Branching metallic crystals that grow from the negative electrode during fast charging.",
                    explanation = "Lithium dendrites are tree-like metal growths that can penetrate separators, causing short circuits and thermal runaway."
                ),
                Question(
                    question = "In what year was the Nobel Prize in Chemistry awarded to Goodenough, Whittingham, and Yoshino for developing lithium-ion batteries?",
                    firstResponse = "2019",
                    secondResponse = "1923",
                    thirdResponse = "1975",
                    correctAnswer = 1,
                    hint = "Awarded recently to honor the portable energy revolution powering smartphones and EVs.",
                    explanation = "The 2019 Nobel Prize in Chemistry celebrated the development of lithium-ion batteries that revolutionized portable electronics."
                ),
                Question(
                    question = "Which lightweight alkali metal has the highest theoretical electrochemical capacity and lowest density for battery anodes?",
                    firstResponse = "Pure Lithium (Li)",
                    secondResponse = "Lead (Pb)",
                    thirdResponse = "Iron (Fe)",
                    correctAnswer = 1,
                    hint = "Element number 3 on the periodic table, the lightest solid metal on Earth.",
                    explanation = "Lithium metal anodes offer the highest theoretical specific capacity (3,860 mAh/g), drastically boosting battery energy density."
                ),
                Question(
                    question = "What major safety hazard is virtually eliminated by replacing liquid battery electrolytes with solid ceramics?",
                    firstResponse = "Thermal runaway and flammable fires",
                    secondResponse = "Radioactive fallout",
                    thirdResponse = "Rust formation",
                    correctAnswer = 1,
                    hint = "Solid inorganic ceramics cannot catch fire or vaporize under extreme temperatures.",
                    explanation = "Solid electrolytes are non-flammable and stable at high temperatures, preventing battery fires even if punctured or crushed."
                )
            )
        ),

        // ==========================================
        // 4. FORESTS (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_forest_1",
            title = "The Wood Wide Web: Underground Mycorrhizal Fungi Connect Entire Forest Canopies",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/d41586-024-00500-2",
            summary = "Radioisotope tracking shows that underground fungal networks shuttle carbon, nitrogen, and drought warning signals between mature trees and saplings.",
            publishedDate = "Recent",
            themeTag = "forets",
            curatedQuestions = listOf(
                Question(
                    question = "What is the symbiotic association between plant roots and underground fungi called?",
                    firstResponse = "Mycorrhiza",
                    secondResponse = "Photosynthesis",
                    thirdResponse = "Fermentation",
                    correctAnswer = 1,
                    hint = "From ancient Greek words meaning 'fungus' and 'root'.",
                    explanation = "Mycorrhizae are mutualistic partnerships where fungi supply soil minerals and water in exchange for plant sugars."
                ),
                Question(
                    question = "What vital nutrients do fungal hyphae deliver to trees in exchange for photosynthesized carbon sugars?",
                    firstResponse = "Phosphorus, nitrogen, and water",
                    secondResponse = "Carbon dioxide and sunlight",
                    thirdResponse = "Pure iron ingots",
                    correctAnswer = 1,
                    hint = "Essential soil minerals that fungi dissolve using microscopic enzyme filaments.",
                    explanation = "Fungi have immense surface area to scavenge mineral phosphorus and nitrogen from soil pores, trading them for tree carbon."
                ),
                Question(
                    question = "Which Canadian forest ecologist pioneered research on 'Mother Trees' nurturing younger seedlings via fungal networks?",
                    firstResponse = "Suzanne Simard",
                    secondResponse = "Rachel Carson",
                    thirdResponse = "Marie Curie",
                    correctAnswer = 1,
                    hint = "Author of 'Finding the Mother Tree' based on British Columbia forest studies.",
                    explanation = "Suzanne Simard demonstrated using carbon isotopes that mature hub trees actively feed understory saplings via shared fungal webs."
                ),
                Question(
                    question = "How do trees under insect attack use the mycorrhizal network to warn neighboring uninfected trees?",
                    firstResponse = "By sending chemical and electrical stress signals through the hyphal pathways",
                    secondResponse = "By shaking their trunks violently",
                    thirdResponse = "By shedding all their leaves instantly",
                    correctAnswer = 1,
                    hint = "Chemical warning compounds trigger defense tannins in neighbors before pests arrive.",
                    explanation = "Trees send biochemical warning molecules through fungal conduits, prompting neighbors to produce anti-herbivore defenses."
                ),
                Question(
                    question = "What underground fungal filaments form the vast web-like body of a fungus beneath the forest floor?",
                    firstResponse = "The mycelium (composed of hyphae)",
                    secondResponse = "The acorn",
                    thirdResponse = "The pine cone",
                    correctAnswer = 1,
                    hint = "The visible mushroom is merely the fruiting body; the true organism is the underground web.",
                    explanation = "The mycelium is the vegetative fungal network composed of thread-like hyphae spanning hundreds of forest meters."
                )
            )
        ),
        ArticleItem(
            id = "en_forest_2",
            title = "Amazon Rainforest LIDAR: Satellites Map Biomass and Identify Flying River Humidity Corridors",
            sourceName = "NASA Earth Observatory",
            url = "https://earthobservatory.nasa.gov/features/amazon-flying-rivers",
            summary = "Laser altimetry missions map the 3D structure of the Amazon basin, documenting how tree evapotranspiration produces continental aerial rivers.",
            publishedDate = "Recent",
            themeTag = "forets",
            curatedQuestions = listOf(
                Question(
                    question = "What meteorological phenomenon describes the massive atmospheric water vapor streams pumped by the Amazon into South America?",
                    firstResponse = "Flying rivers (Ríos Voladores)",
                    secondResponse = "Ocean hurricanes",
                    thirdResponse = "Polar vortexes",
                    correctAnswer = 1,
                    hint = "Trees pump up to 20 billion tons of water vapor into the air daily, creating aerial moisture streams.",
                    explanation = "Flying rivers are vapor plumes carried across South America, providing essential rains for agriculture in Brazil and Argentina."
                ),
                Question(
                    question = "What remote sensing technology uses pulsed laser beams to map the 3D canopy height and biomass of forests?",
                    firstResponse = "LIDAR (Light Detection and Ranging)",
                    secondResponse = "AM Radio",
                    thirdResponse = "Sonar depth sounders",
                    correctAnswer = 1,
                    hint = "Similar to radar, but uses light pulses instead of radio waves.",
                    explanation = "LIDAR measures the time taken for laser pulses to bounce back, generating precise 3D canopy elevation maps."
                ),
                Question(
                    question = "Approximately how much water can a single large Amazonian rainforest tree release into the atmosphere per day via transpiration?",
                    firstResponse = "Up to 1,000 liters of water",
                    secondResponse = "Less than one drop",
                    thirdResponse = "Over 100 million tons",
                    correctAnswer = 1,
                    hint = "Deep root systems pump hundreds of gallons of moisture upward from groundwater every day.",
                    explanation = "A mature canopy tree in the Amazon transpires up to 1,000 liters of water daily, acting like a giant natural vapor pump."
                ),
                Question(
                    question = "What mountain range blocks the Amazon's westward moisture flow, redirecting it south toward central South America?",
                    firstResponse = "The Andes Mountain Range",
                    secondResponse = "The Rocky Mountains",
                    thirdResponse = "The Alps",
                    correctAnswer = 1,
                    hint = "The world's longest continental mountain range along the western edge of South America.",
                    explanation = "The towering Andes act as a natural barrier, turning moisture-laden Atlantic air masses south to irrigate South American plains."
                ),
                Question(
                    question = "What tipping point risk do scientists warn the Amazon faces if total deforestation exceeds 20% to 25%?",
                    firstResponse = "Dieback and irreversible transition into a degraded savanna ecosystem",
                    secondResponse = "Turning into a freezing Arctic glacier",
                    thirdResponse = "Instant volcanic flooding",
                    correctAnswer = 1,
                    hint = "Reduced tree canopy lowers rainfall, triggering drying cycles that prevent rainforest regeneration.",
                    explanation = "The Amazon tipping point hypothesis suggests losing 20-25% forest cover could disrupt rain cycles and trigger savanna dieback."
                )
            )
        ),
        ArticleItem(
            id = "en_forest_3",
            title = "Mangrove Coastal Forests: Supercharged Blue Carbon Sinks Guarding Tropical Shores",
            sourceName = "National Geographic",
            url = "https://www.nationalgeographic.com/environment/article/mangrove-forests-blue-carbon-protection",
            summary = "Field analyses show that mangrove stilt roots trap rich mud, storing up to four times more carbon per hectare than inland tropical rainforests.",
            publishedDate = "Recent",
            themeTag = "forets",
            curatedQuestions = listOf(
                Question(
                    question = "What specialized breathing aerial roots do mangrove trees grow above waterlogged soil to absorb oxygen?",
                    firstResponse = "Pneumatophores",
                    secondResponse = "Leaves",
                    thirdResponse = "Flower petals",
                    correctAnswer = 1,
                    hint = "Pencil-like or stilt roots that project into the air to breathe during low tide.",
                    explanation = "Pneumatophores are specialized erect roots with porous lenticels that allow gas exchange in oxygen-starved mud."
                ),
                Question(
                    question = "What botanical term describes plants like mangroves capable of thriving in highly saline coastal saltwater?",
                    firstResponse = "Halophytes",
                    secondResponse = "Xerophytes",
                    thirdResponse = "Epiphytes",
                    correctAnswer = 1,
                    hint = "From the Greek word for 'salt' (halos) and 'plant' (phyton).",
                    explanation = "Halophytes possess salt-filtering root membranes or salt-excreting leaf glands that permit survival in sea water."
                ),
                Question(
                    question = "Why do mangrove soils store carbon so much longer and denser than dry upland forest soils?",
                    firstResponse = "Waterlogged anaerobic conditions dramatically slow down bacterial decomposition",
                    secondResponse = "The mud is frozen solid",
                    thirdResponse = "Carbon is converted into lead",
                    correctAnswer = 1,
                    hint = "Lack of oxygen underwater prevents aerobic microbes from breaking down dead organic matter.",
                    explanation = "Anaerobic tidal sediments prevent organic matter from decomposing, locking carbon deep in sediment for centuries."
                ),
                Question(
                    question = "What natural coastal hazard do mangrove root tangles buffer against by dampening surge energy?",
                    firstResponse = "Storm surges, tsunamis, and coastal erosion",
                    secondResponse = "Meteor strikes",
                    thirdResponse = "Desert sandstorms",
                    correctAnswer = 1,
                    hint = "Dense stilt roots reduce wave height by up to 66% across a 100-meter forest belt.",
                    explanation = "Mangroves serve as living seawalls, breaking storm waves and shielding coastal villages from cyclone damage."
                ),
                Question(
                    question = "What commercial industry has been responsible for destroying over 30% of global mangrove ecosystems since 1980?",
                    firstResponse = "Industrial shrimp and aquaculture farming",
                    secondResponse = "Deep-sea diamond mining",
                    thirdResponse = "Geothermal drilling",
                    correctAnswer = 1,
                    hint = "Clearing intertidal zones to construct commercial saltwater prawn ponds.",
                    explanation = "Shrimp aquaculture expansion has cleared vast mangrove belts, compromising coastal resilience and fisheries."
                )
            )
        ),
        ArticleItem(
            id = "en_forest_4",
            title = "Boreal Taiga Forests: Circumpolar Conifer Belts Guarding Earth's Largest Soil Carbon Vault",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.ade0700",
            summary = "Encircling the subarctic globe across Canada, Scandinavia, and Siberia, the taiga stores more terrestrial carbon in peat and permafrost than all tropical forests combined.",
            publishedDate = "Recent",
            themeTag = "forets",
            curatedQuestions = listOf(
                Question(
                    question = "What biome represents the world's largest contiguous terrestrial biome on Earth?",
                    firstResponse = "The Boreal Forest (Taiga)",
                    secondResponse = "The Sahara Desert",
                    thirdResponse = "The Savanna",
                    correctAnswer = 1,
                    hint = "The vast northern ring of spruce, pine, and larch encircling the subarctic.",
                    explanation = "The boreal forest (taiga) spans roughly 17 million square kilometers across the northern latitudes of Earth."
                ),
                Question(
                    question = "Where is the vast majority of carbon stored in the boreal forest ecosystem?",
                    firstResponse = "In thick, cold peat soils and permafrost beneath the trees",
                    secondResponse = "In the leaves of deciduous birch trees",
                    thirdResponse = "Suspended in the air above clouds",
                    correctAnswer = 1,
                    hint = "Cold subarctic temperatures slow decay, creating meters-deep organic soil deposits.",
                    explanation = "Over 85% of boreal carbon is locked in underground peat and permafrost rather than in tree trunks."
                ),
                Question(
                    question = "What shape of needles allows evergreen conifers to withstand heavy winter snowfalls without breaking?",
                    firstResponse = "Flexible needle-like leaves with waxy coatings that shed snow and retain water",
                    secondResponse = "Broad flat leaves the size of dinner plates",
                    thirdResponse = "Hollow glass thorns",
                    correctAnswer = 1,
                    hint = "Thin needles and conical tree shapes allow heavy snow to slide off easily.",
                    explanation = "Conifers have needle-like foliage with thick waxy cuticles that resist frost drying and prevent snow build-up."
                ),
                Question(
                    question = "What unique deciduous conifer tree in the Siberian taiga sheds all its soft needles every autumn?",
                    firstResponse = "The Larch (Larix)",
                    secondResponse = "The Scots Pine",
                    thirdResponse = "The Norway Spruce",
                    correctAnswer = 1,
                    hint = "It turns brilliant gold in October before dropping its needles to survive -60 °C winters.",
                    explanation = "Larches are deciduous conifers that drop their needles each winter to avoid frost desiccation in extreme Siberian cold."
                ),
                Question(
                    question = "What severe climate threat accelerates the thawing of boreal permafrost and peat soils?",
                    firstResponse = "Intensifying summer wildfires and heatwaves in high northern latitudes",
                    secondResponse = "Ocean tides rising into mountains",
                    thirdResponse = "Volcanic eruptions beneath the ice",
                    correctAnswer = 1,
                    hint = "Drying peat burns deep underground, releasing centuries-old carbon into the atmosphere.",
                    explanation = "Boreal megafires burn through insulating moss layers, triggering permafrost melt and releasing methane and CO2."
                )
            )
        ),
        ArticleItem(
            id = "en_forest_5",
            title = "Agroforestry Revolution: Intercropping Native Trees with Food Crops Restores Soil Microbiomes",
            sourceName = "Nature Food",
            url = "https://www.nature.com/articles/s43016-024-00910-x",
            summary = "Long-term field trials demonstrate that mixing nitrogen-fixing trees with cereal crops boosts grain yields by 40% while slashing synthetic fertilizer needs.",
            publishedDate = "Recent",
            themeTag = "forets",
            curatedQuestions = listOf(
                Question(
                    question = "What agricultural practice integrates trees and shrubs into crop and animal farming systems?",
                    firstResponse = "Agroforestry",
                    secondResponse = "Monoculture",
                    thirdResponse = "Hydroponics",
                    correctAnswer = 1,
                    hint = "Combining agriculture and forestry on the same parcel of land.",
                    explanation = "Agroforestry deliberately mixes woody perennials with crops or livestock, creating biodiverse, resilient farming systems."
                ),
                Question(
                    question = "Which family of trees can fix atmospheric nitrogen directly into the soil via root nodules containing Rhizobium bacteria?",
                    firstResponse = "Leguminous trees (Fabaceae)",
                    secondResponse = "Pine trees",
                    thirdResponse = "Eucalyptus trees",
                    correctAnswer = 1,
                    hint = "Trees related to peas and beans that enrich agricultural soil naturally.",
                    explanation = "Legume trees form symbioses with Rhizobium bacteria, converting inert atmospheric N2 gas into bioavailable soil nitrogen."
                ),
                Question(
                    question = "How do deep tree roots benefit adjacent shallow-rooted crops during summer droughts?",
                    firstResponse = "Via hydraulic lift: drawing moisture from deep aquifers and weeping it into topsoil",
                    secondResponse = "By drinking all water and killing the crops",
                    thirdResponse = "By heating the soil to 100 °C",
                    correctAnswer = 1,
                    hint = "Deep roots act like natural water pumps, raising moisture toward shallow surface layers overnight.",
                    explanation = "Hydraulic lift occurs when deep taproots draw water from deep moist layers and release a portion into dry surface soil at night."
                ),
                Question(
                    question = "What natural windbreak benefit do boundary hedgerows and tree lines provide to agricultural fields?",
                    firstResponse = "They reduce wind erosion, lower crop evapotranspiration, and shelter pollinating insects",
                    secondResponse = "They block all air from reaching the crops",
                    thirdResponse = "They make soil radioactive",
                    correctAnswer = 1,
                    hint = "Shelterbelts slow down strong winds that would otherwise blow away fertile topsoil.",
                    explanation = "Tree shelterbelts protect soil from wind erosion, create microclimates that retain moisture, and provide wildlife corridors."
                ),
                Question(
                    question = "What traditional European agroforestry system combines widely spaced oak trees with grazed pastures and cereal crops?",
                    firstResponse = "The Dehesa (or Montado in Portugal)",
                    secondResponse = "The Bocage",
                    thirdResponse = "The Polder",
                    correctAnswer = 1,
                    hint = "Famous in Spain and Portugal where Iberian pigs graze acorns beneath holm oaks.",
                    explanation = "The Dehesa is a centuries-old agrosilvopastoral system in western Iberia, combining oak savannah, pasture, and acorn forage."
                )
            )
        ),

        // ==========================================
        // 5. CLIMATE (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_climate_1",
            title = "Arctic Ice Albedo Feedback: How Melting Sea Ice Accelerates Polar Warming",
            sourceName = "NASA Earth Observatory",
            url = "https://earthobservatory.nasa.gov/features/arctic-ice-albedo",
            summary = "Satellite radiometer records show that transitioning from white reflective sea ice to dark ocean water triples local solar radiation absorption.",
            publishedDate = "Recent",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "What physical property measures the fraction of incoming solar radiation reflected by a surface?",
                    firstResponse = "Albedo",
                    secondResponse = "Conductivity",
                    thirdResponse = "Viscosity",
                    correctAnswer = 1,
                    hint = "Ranging from 0 (total absorption) to 1 (total reflection), from the Latin word for 'whiteness'.",
                    explanation = "Albedo is the reflectivity of a surface: fresh snow has a high albedo (~0.85), while open dark ocean water has a low albedo (~0.06)."
                ),
                Question(
                    question = "Approximately what percentage of sunlight is reflected by fresh white Arctic snow compared to open ocean water?",
                    firstResponse = "Snow reflects about 80–90%, while open ocean reflects only about 6–10%",
                    secondResponse = "Snow reflects 0%, water reflects 100%",
                    thirdResponse = "Both reflect exactly 50%",
                    correctAnswer = 1,
                    hint = "White snow acts like a mirror, whereas dark water absorbs over 90% of solar heat.",
                    explanation = "Fresh snow reflects up to 90% of solar radiation back to space, while dark seawater absorbs over 90% as heat."
                ),
                Question(
                    question = "What kind of feedback loop occurs when ice melt leads to warmer water, which in turn melts even more ice?",
                    firstResponse = "A positive feedback loop (self-reinforcing warming)",
                    secondResponse = "A negative cooling loop",
                    thirdResponse = "A neutral cycle",
                    correctAnswer = 1,
                    hint = "The outcome reinforces and accelerates the initial warming process.",
                    explanation = "The ice-albedo feedback is a classic positive feedback mechanism that accelerates Arctic amplification."
                ),
                Question(
                    question = "By roughly how many times faster is the Arctic warming compared to the global planetary average?",
                    firstResponse = "Nearly 3 to 4 times faster (Arctic amplification)",
                    secondResponse = "It is actually cooling",
                    thirdResponse = "At exactly the same speed",
                    correctAnswer = 1,
                    hint = "The polar region experiences the most rapid warming trend on Earth.",
                    explanation = "Arctic amplification causes the polar north to warm roughly 3 to 4 times faster than the rest of the planet."
                ),
                Question(
                    question = "What is the fundamental difference between sea ice (pack ice) and a continental ice sheet (glacier)?",
                    firstResponse = "Sea ice is frozen ocean water floating at sea; glaciers form from compressed snowfall on land",
                    secondResponse = "Sea ice is composed of solid volcanic rock",
                    thirdResponse = "There is no physical difference",
                    correctAnswer = 1,
                    hint = "One floats on the ocean surface; the other rests on continental bedrock.",
                    explanation = "Sea ice freezes from ocean saltwater, whereas glaciers and ice sheets accumulate on land from thousands of years of snowfall."
                )
            )
        ),
        ArticleItem(
            id = "en_climate_2",
            title = "Atmospheric CO2 Tracking: Mauna Loa Observatory Observes Historic Carbon Trends",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.ade0900",
            summary = "Continuous high-precision sensor records in Hawaii show atmospheric carbon dioxide crossing 425 parts per million, driven by fossil fuel combustion.",
            publishedDate = "Recent",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "What famous scientific graph plots the ongoing rise in atmospheric carbon dioxide concentrations since 1958?",
                    firstResponse = "The Keeling Curve",
                    secondResponse = "The Richter Scale",
                    thirdResponse = "The Fibonacci Spiral",
                    correctAnswer = 1,
                    hint = "Initiated by Charles David Keeling at the Mauna Loa Observatory in Hawaii.",
                    explanation = "The Keeling Curve is the famous continuous measurement record of atmospheric CO2 started by Charles Keeling in 1958."
                ),
                Question(
                    question = "What was the approximate pre-industrial concentration of atmospheric CO2 prior to the 1800s?",
                    firstResponse = "About 280 ppm (parts per million)",
                    secondResponse = "Over 10,000 ppm",
                    thirdResponse = "Exactly 0 ppm",
                    correctAnswer = 1,
                    hint = "Ice core records show CO2 hovered near 280 ppm for thousands of years before the industrial revolution.",
                    explanation = "Before industrial fossil fuel burning, atmospheric CO2 fluctuated between roughly 180 ppm (ice ages) and 280 ppm (interglacials)."
                ),
                Question(
                    question = "Why does the Keeling Curve exhibit a regular annual sawtooth oscillation each year?",
                    firstResponse = "Due to the seasonal growth and decay of Northern Hemisphere vegetation",
                    secondResponse = "Because factories shut down every weekend",
                    thirdResponse = "Because the sun turns off in winter",
                    correctAnswer = 1,
                    hint = "The Northern Hemisphere has far more land vegetation: in northern spring, plants absorb CO2; in winter, leaves decay.",
                    explanation = "Northern hemisphere land vegetation breathes in CO2 during spring/summer and releases it during autumn/winter decay."
                ),
                Question(
                    question = "What type of electromagnetic radiation emitted by Earth is trapped by greenhouse gas molecules in the atmosphere?",
                    firstResponse = "Infrared radiation (heat energy)",
                    secondResponse = "Gamma rays",
                    thirdResponse = "Visible green light",
                    correctAnswer = 1,
                    hint = "Greenhouse gases are transparent to visible sunlight but absorb longwave thermal radiation emitted by Earth.",
                    explanation = "Earth re-emits absorbed solar energy as longwave infrared radiation, which greenhouse gases absorb and re-radiate."
                ),
                Question(
                    question = "Which greenhouse gas has a global warming potential roughly 28 to 36 times higher than CO2 over a 100-year timescale?",
                    firstResponse = "Methane (CH4)",
                    secondResponse = "Oxygen (O2)",
                    thirdResponse = "Argon (Ar)",
                    correctAnswer = 1,
                    hint = "A simple hydrocarbon emitted by livestock digestion, rice paddies, and natural gas leaks.",
                    explanation = "Methane (CH4) is a potent short-lived climate pollutant with ~30x the warming potential of CO2 over a century."
                )
            )
        ),
        ArticleItem(
            id = "en_climate_3",
            title = "Direct Air Capture: Geothermal Fans Trap Ambient Carbon Dioxide in Basalt Formations",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/d41586-024-00600-3",
            summary = "Industrial direct air capture facilities in Iceland dissolve ambient CO2 in water and inject it into basalt, where it turns to stone within two years.",
            publishedDate = "Recent",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "What chemical technology extracts carbon dioxide directly from ambient outdoor air?",
                    firstResponse = "Direct Air Capture (DAC)",
                    secondResponse = "Hydraulic fracturing",
                    thirdResponse = "Desalination",
                    correctAnswer = 1,
                    hint = "Abbreviated as DAC, it uses chemical sorbents and fans to capture CO2 directly from atmosphere.",
                    explanation = "Direct Air Capture (DAC) uses chemical contactors or solid sorbents to pull CO2 out of ambient air."
                ),
                Question(
                    question = "In the Carbfix process in Iceland, what happens to CO2 dissolved in water when injected into deep basalt formations?",
                    firstResponse = "It reacts with calcium and magnesium to permanently mineralize into solid stone (calcite)",
                    secondResponse = "It explodes into volcanic lava",
                    thirdResponse = "It turns into liquid crude petroleum",
                    correctAnswer = 1,
                    hint = "Natural mineral carbonation turns the dissolved gas into carbonate rock within two years.",
                    explanation = "Dissolved CO2 reacts with cations in basaltic rock to precipitate solid carbonate minerals (limestone), permanently trapping it."
                ),
                Question(
                    question = "What is the primary technical challenge currently limiting the global deployment of Direct Air Capture?",
                    firstResponse = "High energy consumption and financial cost per ton of CO2 captured",
                    secondResponse = "There is not enough carbon in the air",
                    thirdResponse = "Captured CO2 attracts lightning strikes",
                    correctAnswer = 1,
                    hint = "Because CO2 is dilute in air (0.04%), processing huge volumes of air requires massive energy and cost.",
                    explanation = "Because atmospheric CO2 concentration is roughly 420 ppm, moving and heating millions of cubic meters of air is energy-intensive."
                ),
                Question(
                    question = "What volcanic rock formation, rich in reactive divalent cations, is considered the prime target for permanent CO2 mineralization?",
                    firstResponse = "Basalt",
                    secondResponse = "Sandstone",
                    thirdResponse = "Coal",
                    correctAnswer = 1,
                    hint = "A dark igneous rock formed from the rapid cooling of magnesium- and iron-rich lava.",
                    explanation = "Basalt contains abundant calcium, magnesium, and iron silicates that rapidly bond with CO2 to form stable carbonates."
                ),
                Question(
                    question = "What order of magnitude of annual global CO2 emissions must humanity eliminate to achieve net zero?",
                    firstResponse = "Roughly 35 to 40 billion metric tons (gigatons) per year",
                    secondResponse = "Around 50 kilograms",
                    thirdResponse = "Over 10 trillion tons",
                    correctAnswer = 1,
                    hint = "Global energy and industrial emissions currently hover near 37 gigatons of CO2 each year.",
                    explanation = "Global anthropogenic CO2 emissions are approximately 37 billion metric tons (gigatons) annually."
                )
            )
        ),
        ArticleItem(
            id = "en_climate_4",
            title = "Urban Heat Islands: How City Tree Canopies Cool Neighborhood Streets by up to 5 °C",
            sourceName = "Scientific American",
            url = "https://www.scientificamerican.com/article/urban-heat-islands-tree-canopy-cooling",
            summary = "Thermal imaging satellite data confirms that dense tree corridors, reflective roofs, and permeable pavements mitigate extreme summer temperatures in dense cities.",
            publishedDate = "Recent",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "What phenomenon causes urban metropolitan areas to experience significantly higher temperatures than surrounding rural land?",
                    firstResponse = "The Urban Heat Island (UHI) effect",
                    secondResponse = "Atmospheric inversion",
                    thirdResponse = "The Coriolis effect",
                    correctAnswer = 1,
                    hint = "Dark asphalt, concrete, and lack of vegetation trap and re-radiate heat.",
                    explanation = "Urban Heat Islands occur when dense concrete, buildings, and roads absorb solar heat and release it slowly at night."
                ),
                Question(
                    question = "Through what dual mechanisms do mature street trees cool surrounding urban air?",
                    firstResponse = "Physical solar shading and evaporative cooling via transpiration",
                    secondResponse = "By emitting liquid nitrogen",
                    thirdResponse = "By blocking wind completely",
                    correctAnswer = 1,
                    hint = "Leaves block direct sunlight and evaporate groundwater, consuming heat energy.",
                    explanation = "Tree canopies block direct solar radiation from heating pavements, and evapotranspiration cools the ambient air."
                ),
                Question(
                    question = "What architectural intervention involves planting vegetation on building rooftops to lower indoor cooling demand?",
                    firstResponse = "Green roofs (living roofs)",
                    secondResponse = "Chimney flues",
                    thirdResponse = "Tin foil sheeting",
                    correctAnswer = 1,
                    hint = "Vegetated roof gardens that absorb rainwater and insulate buildings.",
                    explanation = "Green roofs replace heat-absorbing dark membrane roofs with soil and sedum plants, slashing cooling energy use."
                ),
                Question(
                    question = "What high-albedo material treatment can be applied to asphalt roads and building roofs to reflect sunlight back to space?",
                    firstResponse = "Cool roofs and reflective white or light-colored coatings",
                    secondResponse = "Black coal tar coatings",
                    thirdResponse = "Lead sheeting",
                    correctAnswer = 1,
                    hint = "Light-colored surfaces reflect up to 80% of solar radiation instead of absorbing it.",
                    explanation = "Cool roofs use high-reflectance white pigments to keep surface temperatures up to 28 °C cooler than traditional dark roofs."
                ),
                Question(
                    question = "What type of urban paving material allows rainwater to infiltrate the ground naturally instead of causing runoff?",
                    firstResponse = "Permeable (porous) pavements",
                    secondResponse = "Solid polished marble",
                    thirdResponse = "Dense asphalt sheets",
                    correctAnswer = 1,
                    hint = "Pavements engineered with interconnected voids that allow water to soak into subsoil.",
                    explanation = "Permeable pavers allow water to infiltrate soil, recharging groundwater tables and reducing urban heat through evaporation."
                )
            )
        ),
        ArticleItem(
            id = "en_climate_5",
            title = "El Niño and La Niña: Climate Oscillations in the Pacific Reshape Global Weather Systems",
            sourceName = "NOAA Climate",
            url = "https://www.climate.gov/enso/pacific-ocean-climate-oscillation",
            summary = "Satellite ocean surface altimetry maps the shifting warm-water pools in the equatorial Pacific, forecasting teleconnected droughts and monsoon disruptions.",
            publishedDate = "Recent",
            themeTag = "climat",
            curatedQuestions = listOf(
                Question(
                    question = "What does the climate acronym ENSO stand for?",
                    firstResponse = "El Niño-Southern Oscillation",
                    secondResponse = "Ecological Natural Solar Orbit",
                    thirdResponse = "Earth Nitrogen Soil Organization",
                    correctAnswer = 1,
                    hint = "The combined oceanic (El Niño) and atmospheric (Southern Oscillation) phenomenon in the Pacific.",
                    explanation = "ENSO stands for El Niño-Southern Oscillation, a recurring climate pattern involving changes in equatorial Pacific sea surface temperatures."
                ),
                Question(
                    question = "What happens to the eastern tropical Pacific Ocean off South America during an El Niño event?",
                    firstResponse = "Sea surface waters become significantly warmer than normal",
                    secondResponse = "The ocean freezes into solid ice",
                    thirdResponse = "All ocean water evaporates into space",
                    correctAnswer = 1,
                    hint = "Trade winds weaken, allowing a warm pool of water to slosh eastward toward South America.",
                    explanation = "During El Niño, weakened trade winds allow warm western Pacific water to spread eastward, warming sea temperatures off Peru."
                ),
                Question(
                    question = "What phase of the ENSO cycle is characterized by unusually cold sea surface temperatures in the central and eastern Pacific?",
                    firstResponse = "La Niña",
                    secondResponse = "El Niño",
                    thirdResponse = "The Monsoon",
                    correctAnswer = 1,
                    hint = "Named 'the little girl' in Spanish, the opposite cool phase of El Niño.",
                    explanation = "La Niña is the cool phase of ENSO, marked by stronger trade winds, intense deep-water upwelling, and cooler eastern Pacific waters."
                ),
                Question(
                    question = "What vital oceanographic process is suppressed off the coast of Peru during strong El Niño events, crashing fisheries?",
                    firstResponse = "Coastal upwelling of cold, nutrient-rich deep water",
                    secondResponse = "Ocean tides",
                    thirdResponse = "Water evaporation",
                    correctAnswer = 1,
                    hint = "Warm surface water caps the cold bottom layer, stopping nutrients from rising to feed anchovy schools.",
                    explanation = "El Niño suppresses the Humboldt Current upwelling, cutting off plankton nutrients and causing local fishery collapses."
                ),
                Question(
                    question = "What is the typical recurrence interval of the El Niño-Southern Oscillation cycle?",
                    firstResponse = "Every 2 to 7 years irregularly",
                    secondResponse = "Every 1,000 years exactly",
                    thirdResponse = "Every 24 hours",
                    correctAnswer = 1,
                    hint = "It is an irregular periodic climate cycle fluctuating every few years.",
                    explanation = "ENSO cycles occur quasi-periodically every 2 to 7 years, lasting anywhere from 9 to 18 months."
                )
            )
        ),

        // ==========================================
        // 6. SPACE & ASTRONOMY (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_space_1",
            title = "James Webb Space Telescope: Exoplanet Atmosphere Reveals Carbon Dioxide and Water Vapor",
            sourceName = "NASA / ESA",
            url = "https://webbtelescope.org/contents/news-releases/2024/news-2024-100",
            summary = "Transmission spectroscopy with Webb's infrared NIRSpec instrument reveals distinct atmospheric chemical signatures around a distant habitable-zone world.",
            publishedDate = "Recent",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "Around which gravitationally stable orbital position does the James Webb Space Telescope orbit?",
                    firstResponse = "The Second Sun-Earth Lagrange Point (L2)",
                    secondResponse = "Low Earth Orbit (400 km)",
                    thirdResponse = "The surface of the Moon",
                    correctAnswer = 1,
                    hint = "Located about 1.5 million kilometers behind Earth on the side facing away from the Sun.",
                    explanation = "JWST orbits Lagrange Point L2, where the gravitational forces of Earth and Sun balance the orbital motion of the observatory."
                ),
                Question(
                    question = "What primary electromagnetic spectrum wavelengths does the James Webb Space Telescope observe?",
                    firstResponse = "Infrared wavelengths (near-infrared and mid-infrared)",
                    secondResponse = "Gamma rays and X-rays",
                    thirdResponse = "AM radio waves",
                    correctAnswer = 1,
                    hint = "Infrared allows Webb to peer through cosmic dust clouds and observe redshifted ancient light.",
                    explanation = "Webb is designed primarily for infrared astronomy, enabling observations of distant redshifted galaxies and cool exoplanet atmospheres."
                ),
                Question(
                    question = "What precious metal coats the 18 hexagonal beryllium segments of Webb's 6.5-meter primary mirror?",
                    firstResponse = "Pure gold (Au)",
                    secondResponse = "Pure silver",
                    thirdResponse = "Polished copper",
                    correctAnswer = 1,
                    hint = "A microscopic layer of this dense yellow metal provides peak reflection for infrared light.",
                    explanation = "A vapor-deposited 100-nanometer layer of gold coats the mirror segments, optimizing reflection of infrared wavelengths."
                ),
                Question(
                    question = "What spectroscopic technique detects atmospheric gases on exoplanets as they pass in front of their host stars?",
                    firstResponse = "Transmission spectroscopy",
                    secondResponse = "Radio triangulation",
                    thirdResponse = "Stellar combustion",
                    correctAnswer = 1,
                    hint = "Starlight filters through the planetary atmosphere, leaving absorption fingerprints for each chemical molecule.",
                    explanation = "Transmission spectroscopy analyzes filtered starlight during a transit to identify molecular absorption fingerprints."
                ),
                Question(
                    question = "What astronomical term designates the distance from a star where liquid water can stably exist on a rocky planet's surface?",
                    firstResponse = "The Habitable Zone (or Goldilocks Zone)",
                    secondResponse = "The Kuiper Belt",
                    thirdResponse = "The Event Horizon",
                    correctAnswer = 1,
                    hint = "Where temperatures are neither too hot nor too cold for liquid water.",
                    explanation = "The circumstellar habitable zone is the orbital band where stellar flux allows liquid surface water to persist."
                )
            )
        ),
        ArticleItem(
            id = "en_space_2",
            title = "Artemis Lunar Program: Water Ice Deposits Mapped in Permanently Shadowed Moon Craters",
            sourceName = "NASA",
            url = "https://www.nasa.gov/artemis/lunar-south-pole-water-ice",
            summary = "Orbital radar data confirms vast deposits of water ice inside sub-zero craters at the lunar south pole, providing a vital resource for human exploration.",
            publishedDate = "Recent",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "At which lunar region are vast deposits of water ice concentrated in permanently shadowed craters?",
                    firstResponse = "The Lunar South Pole",
                    secondResponse = "The Sea of Tranquility at the equator",
                    thirdResponse = "The exact center of the visible near side",
                    correctAnswer = 1,
                    hint = "Because of the Moon's low axial tilt, deep crater floors here never see direct sunlight.",
                    explanation = "The Moon's south pole features deep craters where rim shadows keep interior temperatures below -200 °C permanently."
                ),
                Question(
                    question = "Why is water ice on the Moon considered the ultimate 'liquid gold' for deep space exploration?",
                    firstResponse = "It can be split into hydrogen fuel and oxygen for breathing and rocket propulsion",
                    secondResponse = "It is made of pure liquid gold metal",
                    thirdResponse = "It can be sold as luxury diamonds on Earth",
                    correctAnswer = 1,
                    hint = "Electrolysis of lunar water produces hydrogen (rocket propellant) and oxygen (life support and oxidizer).",
                    explanation = "Extracting lunar water allows on-site production of hydrogen fuel and breathable oxygen, avoiding costly launches from Earth."
                ),
                Question(
                    question = "What is the name of NASA's crewed space exploration program aiming to land humans back on the Moon?",
                    firstResponse = "The Artemis program",
                    secondResponse = "The Apollo program",
                    thirdResponse = "The Gemini program",
                    correctAnswer = 1,
                    hint = "Named after the Greek goddess of the Moon, the twin sister of Apollo.",
                    explanation = "The Artemis program is NASA's modern initiative to establish a sustainable human presence on and around the Moon."
                ),
                Question(
                    question = "Why does the Moon experience extreme temperature swings between day (+120 °C) and night (-130 °C)?",
                    firstResponse = "Because it has no significant atmosphere to insulate and distribute heat",
                    secondResponse = "Because it orbits inside the Sun",
                    thirdResponse = "Because it rotates once every minute",
                    correctAnswer = 1,
                    hint = "Without a thick gaseous blanket, heat radiates immediately into the vacuum of space.",
                    explanation = "The Moon has an extremely tenuous exosphere, meaning there is no air blanket to trap daytime heat or distribute warmth."
                ),
                Question(
                    question = "What is the planned orbital space station called that will circle the Moon to support lunar surface missions?",
                    firstResponse = "The Lunar Gateway",
                    secondResponse = "The Mir Space Station",
                    thirdResponse = "Skylab",
                    correctAnswer = 1,
                    hint = "An international outpost serving as a staging hub for lunar landings and Mars missions.",
                    explanation = "The Lunar Gateway is an international space station in lunar orbit that will act as a communications and staging hub."
                )
            )
        ),
        ArticleItem(
            id = "en_space_3",
            title = "Solar Orbiter: Closest Probe Images Reveal Miniature 'Campfire' Flares in Sun's Corona",
            sourceName = "ESA / NASA",
            url = "https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter",
            summary = "Extreme ultraviolet cameras aboard ESA's Solar Orbiter capture millions of ubiquitous micro-flares heating the solar corona to millions of degrees.",
            publishedDate = "Recent",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "What is the major scientific mystery regarding the Sun's outer atmosphere (the corona)?",
                    firstResponse = "The corona is over a million degrees hotter than the Sun's visible surface (photosphere)",
                    secondResponse = "The corona is completely frozen at absolute zero",
                    thirdResponse = "The corona orbits the planet Jupiter",
                    correctAnswer = 1,
                    hint = "The surface is ~5,500 °C, but the surrounding corona mysteriously reaches 1,000,000 °C to 2,000,000 °C.",
                    explanation = "The coronal heating problem puzzles physicists: why the corona is millions of degrees hotter than the surface below it."
                ),
                Question(
                    question = "What stream of charged particles (electrons and protons) flows continuously outward from the Sun into the solar system?",
                    firstResponse = "The Solar Wind",
                    secondResponse = "The Polar Jet Stream",
                    thirdResponse = "The Galactic Gulf Stream",
                    correctAnswer = 1,
                    hint = "A supersonic plasma wind that blows past planets, creating auroras on Earth.",
                    explanation = "The solar wind is a continuous stream of plasma released from the upper atmosphere of the Sun."
                ),
                Question(
                    question = "What shields life on Earth from the hazardous radiation and energetic particles of the solar wind?",
                    firstResponse = "Earth's geomagnetic field (magnetosphere)",
                    secondResponse = "The cloud layer",
                    thirdResponse = "The ozone layer alone",
                    correctAnswer = 1,
                    hint = "Generated by the churning molten iron dynamo in Earth's outer core.",
                    explanation = "Earth's magnetic field deflects the solar wind, forming the magnetosphere that shields our atmosphere from erosion."
                ),
                Question(
                    question = "What visual natural light display is produced when solar wind particles collide with atmospheric oxygen and nitrogen near the poles?",
                    firstResponse = "Auroras (Northern and Southern Lights)",
                    secondResponse = "Solar eclipses",
                    thirdResponse = "Rainbows",
                    correctAnswer = 1,
                    hint = "Aurora Borealis in the north and Aurora Australis in the south.",
                    explanation = "Auroras occur when solar charged particles excite atmospheric gases, emitting glowing green, red, and violet light."
                ),
                Question(
                    question = "What is the regular periodic cycle length of the Sun's magnetic activity and sunspot count?",
                    firstResponse = "Approximately 11 years",
                    secondResponse = "Exactly 365 days",
                    thirdResponse = "Every 1,000 years",
                    correctAnswer = 1,
                    hint = "The solar cycle oscillates between solar minimum and solar maximum roughly every decade.",
                    explanation = "The solar magnetic cycle lasts approximately 11 years, flipping its magnetic poles at each solar maximum."
                )
            )
        ),
        ArticleItem(
            id = "en_space_4",
            title = "Euclid Space Telescope: Mapping Dark Matter and Cosmic Web Across 10 Billion Light-Years",
            sourceName = "ESA",
            url = "https://www.esa.int/Science_Exploration/Space_Science/Euclid",
            summary = "ESA's Euclid space observatory delivers razor-sharp wide-field images of billions of distant galaxies, charting the unseen gravitational pull of dark matter.",
            publishedDate = "Recent",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "Approximately what percentage of the total matter in the universe is believed to consist of invisible dark matter?",
                    firstResponse = "Roughly 85% of all matter (approx. 27% of total universe energy-matter content)",
                    secondResponse = "Less than 0.001%",
                    thirdResponse = "Exactly 100%",
                    correctAnswer = 1,
                    hint = "Ordinary baryonic matter (atoms forming stars and humans) makes up only about 5% of the cosmos.",
                    explanation = "Ordinary matter constitutes only about 5% of the universe; dark matter makes up ~27%, and dark energy ~68%."
                ),
                Question(
                    question = "How do astronomers detect the presence of dark matter if it does not emit, absorb, or reflect light?",
                    firstResponse = "Through its gravitational lensing effect: bending light from distant galaxies behind it",
                    secondResponse = "By listening to radio music broadcast by dark matter",
                    thirdResponse = "By smelling cosmic gas clouds",
                    correctAnswer = 1,
                    hint = "Einstein's general relativity: massive objects warp spacetime, bending light paths like a glass lens.",
                    explanation = "Dark matter reveals itself through gravitational lensing: its mass warps spacetime and distorts images of background galaxies."
                ),
                Question(
                    question = "What mysterious cosmic component is responsible for the accelerating expansion of the universe?",
                    firstResponse = "Dark Energy",
                    secondResponse = "Solar wind",
                    thirdResponse = "Black hole dust",
                    correctAnswer = 1,
                    hint = "Discovered in 1998 via Type Ia supernovae observations, earning the 2011 Nobel Prize in Physics.",
                    explanation = "Dark energy is the unknown form of energy permeating all space that accelerates the cosmic expansion."
                ),
                Question(
                    question = "What geometric structure describes the large-scale distribution of galaxies linked by filamentary dark matter ribbons?",
                    firstResponse = "The Cosmic Web",
                    secondResponse = "A perfect flat circle",
                    thirdResponse = "A solid steel cube",
                    correctAnswer = 1,
                    hint = "A sponge-like network of galaxy filaments surrounding vast empty cosmic voids.",
                    explanation = "The cosmic web is the interconnected filamentary network of dark matter and galaxies spanning billions of light-years."
                ),
                Question(
                    question = "Which ancient Greek mathematician, famous for his 'Elements' treatise on geometry, is the telescope named after?",
                    firstResponse = "Euclid of Alexandria",
                    secondResponse = "Pythagoras",
                    thirdResponse = "Archimedes",
                    correctAnswer = 1,
                    hint = "The father of geometry whose name adorns the mission mapping the geometry of the dark universe.",
                    explanation = "The Euclid observatory is named after Euclid of Alexandria (~300 BC), reflecting its mission to map the geometry of space."
                )
            )
        ),
        ArticleItem(
            id = "en_space_5",
            title = "Mars Perseverance Rover: River Delta Sediments Reveal Potential Biosignature Clues",
            sourceName = "NASA / JPL",
            url = "https://mars.nasa.gov/perseverance/news/jezero-delta-sediments",
            summary = "Core samples gathered from fine-grained clay formations in Jezero Crater reveal organic carbon molecules deposited during Mars' ancient wet era.",
            publishedDate = "Recent",
            themeTag = "espace",
            curatedQuestions = listOf(
                Question(
                    question = "What geological feature was Jezero Crater billions of years ago when liquid water flowed across Mars?",
                    firstResponse = "An ancient lake fed by a river delta",
                    secondResponse = "A deep volcanic lava ocean",
                    thirdResponse = "A frozen methane glacier",
                    correctAnswer = 1,
                    hint = "Satellite images clearly show river inlet channels depositing fan-shaped delta sediments.",
                    explanation = "Jezero Crater hosted an ancient standing lake and river delta over 3.5 billion years ago, ideal for preserving microfossils."
                ),
                Question(
                    question = "What primary gas makes up more than 95% of Mars' current thin atmosphere?",
                    firstResponse = "Carbon dioxide (CO2)",
                    secondResponse = "Pure oxygen (O2)",
                    thirdResponse = "Methane (CH4)",
                    correctAnswer = 1,
                    hint = "The atmosphere is extremely thin (~0.6% of Earth's pressure) and dominated by CO2.",
                    explanation = "The Martian atmosphere is about 95% carbon dioxide, with traces of nitrogen and argon, and less than 0.15% oxygen."
                ),
                Question(
                    question = "What tiny autonomous technology demonstration completed 72 historic powered flights in the thin air of Mars?",
                    firstResponse = "The Ingenuity Mars Helicopter",
                    secondResponse = "A passenger drone",
                    thirdResponse = "A hot air balloon",
                    correctAnswer = 1,
                    hint = "A 1.8-kilogram dual-rotor rotorcraft that proved powered aerodynamic flight on another planet.",
                    explanation = "The Ingenuity helicopter completed 72 flights on Mars, proving aerodynamic flight in an atmosphere with 1% of Earth's density."
                ),
                Question(
                    question = "What experimental instrument on the Perseverance rover successfully produced breathable oxygen directly from Martian CO2?",
                    firstResponse = "MOXIE (Mars Oxygen ISRU Experiment)",
                    secondResponse = "The solar panel",
                    thirdResponse = "The robotic drill",
                    correctAnswer = 1,
                    hint = "It uses solid oxide electrolysis to split carbon dioxide molecules into carbon monoxide and oxygen.",
                    explanation = "MOXIE demonstrated on-site resource utilization by extracting pure oxygen from Mars' carbon dioxide atmosphere."
                ),
                Question(
                    question = "How are the rock core sample tubes collected by Perseverance planned to be brought back to Earth for laboratory analysis?",
                    firstResponse = "Via the joint NASA-ESA Mars Sample Return (MSR) mission",
                    secondResponse = "They will be launched with a giant catapult",
                    thirdResponse = "They will dissolve naturally on Mars",
                    correctAnswer = 1,
                    hint = "A planned multi-spacecraft campaign involving a sample retrieval lander, Mars ascent rocket, and Earth return orbiter.",
                    explanation = "The Mars Sample Return campaign aims to launch the sealed titanium sample tubes off Mars and return them to Earth."
                )
            )
        ),

        // ==========================================
        // 7. WASTE & RECYCLING (5 articles)
        // ==========================================
        ArticleItem(
            id = "en_waste_1",
            title = "Enzymatic Bio-Recycling: Engineered Bacterial Enzymes Break Down PET Plastic in 10 Hours",
            sourceName = "Nature",
            url = "https://www.nature.com/articles/s41586-024-00700-4",
            summary = "Industrial bioreactors utilizing optimized PETase enzymes depolymerize plastic bottles into pristine monomers for infinite circular remanufacturing.",
            publishedDate = "Recent",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "What does the polymer acronym PET stand for in common beverage bottles and synthetic textile fibers?",
                    firstResponse = "Polyethylene Terephthalate",
                    secondResponse = "Poly Ethylene Toxate",
                    thirdResponse = "Phosphate Ethyl Tar",
                    correctAnswer = 1,
                    hint = "The ubiquitous polyester resin coded with recycling number 1.",
                    explanation = "PET stands for Polyethylene Terephthalate, a thermoplastic polymer widely used in single-use bottles and polyester clothing."
                ),
                Question(
                    question = "What biological enzyme was originally discovered in Ideonella sakaiensis bacteria feeding on plastic outside a recycling plant?",
                    firstResponse = "PETase",
                    secondResponse = "Amylase",
                    thirdResponse = "Lactase",
                    correctAnswer = 1,
                    hint = "Named directly after the PET plastic bonds it enzymatically cleaves.",
                    explanation = "PETase is an enzyme that catalyzes the hydrolysis of polyethylene terephthalate into its building-block monomers."
                ),
                Question(
                    question = "What major advantage does biological enzymatic recycling offer over traditional mechanical shredding and melting?",
                    firstResponse = "It breaks plastic down into virgin-grade chemical monomers that can be rebuilt infinitely without loss of quality",
                    secondResponse = "It burns plastic into ash",
                    thirdResponse = "It turns plastic into pure gold",
                    correctAnswer = 1,
                    hint = "Mechanical recycling degrades plastic strength (downcycling), whereas enzyme depolymerization yields virgin-quality monomers.",
                    explanation = "Enzymatic recycling separates plastic into terephthalic acid and ethylene glycol, allowing infinite circular reuse."
                ),
                Question(
                    question = "What synthetic polymer fabric used widely in fast fashion is chemically identical to PET plastic bottles?",
                    firstResponse = "Polyester",
                    secondResponse = "Natural cotton",
                    thirdResponse = "Pure silk",
                    correctAnswer = 1,
                    hint = "Over 60% of modern clothing contains this petroleum-derived synthetic fiber.",
                    explanation = "Polyester fiber is chemically identical to PET; recycling bottles into polyester fleece is a common form of mechanical downcycling."
                ),
                Question(
                    question = "Why are black or colored plastic containers notoriously difficult for conventional optical recycling sorters to identify?",
                    firstResponse = "Carbon black pigments absorb near-infrared beams, making the container invisible to sorting sensors",
                    secondResponse = "Black plastic is radioactive",
                    thirdResponse = "Black plastic weighs nothing",
                    correctAnswer = 1,
                    hint = "Near-infrared (NIR) optical sensors rely on reflected light to identify resin types, which black pigment absorbs.",
                    explanation = "Carbon black pigments absorb near-infrared light, preventing optical sorting sensors at recycling plants from identifying the polymer."
                )
            )
        ),
        ArticleItem(
            id = "en_waste_2",
            title = "Ocean Plastic Interceptors: Solar-Powered Catamarans Clear River Bottlenecks",
            sourceName = "National Geographic",
            url = "https://www.nationalgeographic.com/environment/article/river-plastic-interceptors-ocean-cleanup",
            summary = "Automated solar conveyor vessels deployed at river mouths extract floating waste before it disperses into open ocean gyres.",
            publishedDate = "Recent",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "According to environmental studies, what percentage of plastic entering oceans originates from rivers and coastal waterways?",
                    firstResponse = "Roughly 80% of marine plastic waste",
                    secondResponse = "Less than 0.5%",
                    thirdResponse = "Exactly 100%",
                    correctAnswer = 1,
                    hint = "Rivers act as the primary conduits carrying land-based urban waste out to sea.",
                    explanation = "Research shows that approximately 80% of ocean plastic enters via rivers, with 1,000 top polluting rivers carrying the bulk."
                ),
                Question(
                    question = "How are autonomous river cleanup vessels like The Ocean Cleanup's Interceptor powered?",
                    firstResponse = "By on-board solar panel arrays and battery storage",
                    secondResponse = "By heavy diesel fuel engines",
                    thirdResponse = "By human oarsmen",
                    correctAnswer = 1,
                    hint = "They operate 100% emission-free using rooftop photovoltaic energy.",
                    explanation = "Interceptors are 100% solar-powered autonomous catamarans, operating quietly around the clock without fossil fuels."
                ),
                Question(
                    question = "Why is capturing plastic waste in rivers considered vastly more effective than collecting it in open oceans?",
                    firstResponse = "Waste is concentrated and has not yet broken down into microscopic, unrecoverable fragments",
                    secondResponse = "River water makes plastic dissolve instantly",
                    thirdResponse = "There are no fish in rivers",
                    correctAnswer = 1,
                    hint = "Stopping macroplastics at river bottlenecks prevents them from fragmenting into trillion-piece microplastic gyres.",
                    explanation = "Tackling waste at the river source catches intact macroplastics before UV and waves grind them into microplastics."
                ),
                Question(
                    question = "What mechanism directs floating debris toward the conveyor mouth of river interceptor vessels?",
                    firstResponse = "Floating angled boom barriers that guide trash along the natural water current",
                    secondResponse = "Underground suction vacuums",
                    thirdResponse = "Giant magnets",
                    correctAnswer = 1,
                    hint = "Permeable floating screens direct floating trash directly onto the central conveyor belt.",
                    explanation = "Floating boom barriers span river sections, using the river's own current to funnel debris into the collection mouth."
                ),
                Question(
                    question = "What commonly discarded single-use consumer item accounts for billions of non-biodegradable pieces entering waterways daily?",
                    firstResponse = "Plastic shopping bags, bottles, and food packaging wrappers",
                    secondResponse = "Cast iron frying pans",
                    thirdResponse = "Wooden telephone poles",
                    correctAnswer = 1,
                    hint = "Packaging polymers designed to be used for minutes but lasting for centuries.",
                    explanation = "Single-use packaging, bags, and bottles represent over 60% of all municipal plastic waste polluting waterways."
                )
            )
        ),
        ArticleItem(
            id = "en_waste_3",
            title = "Urban Mining for Circular Electronics: E-Waste Facilities Recover Gold, Lithium, and Rare Earths",
            sourceName = "Scientific American",
            url = "https://www.scientificamerican.com/article/urban-mining-electronic-waste-recycling",
            summary = "Advanced hydrometallurgical recycling recovers high-purity gold, cobalt, and neodymium from discarded circuit boards at lower energy costs than virgin mining.",
            publishedDate = "Recent",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "What term describes the extraction of precious and critical metals from discarded electronic products rather than geological mines?",
                    firstResponse = "Urban Mining",
                    secondResponse = "Deep-sea drilling",
                    thirdResponse = "Hydraulic fracturing",
                    correctAnswer = 1,
                    hint = "Mining the technological 'ores' accumulated inside cities and recycling scrap yards.",
                    explanation = "Urban mining is the process of recovering raw materials and precious metals from spent capital goods, buildings, and e-waste."
                ),
                Question(
                    question = "How does the concentration of gold in one ton of smartphone circuit boards compare to one ton of natural gold ore?",
                    firstResponse = "Circuits contain up to 50 to 100 times more gold per ton than natural mine ore",
                    secondResponse = "Natural ore contains 10,000 times more gold",
                    thirdResponse = "There is zero gold in smartphones",
                    correctAnswer = 1,
                    hint = "A ton of high-grade e-waste yields several hundred grams of gold, versus only a few grams in typical rock ore.",
                    explanation = "One metric ton of printed circuit boards contains ~150 to 300 grams of gold, compared to only 1–5 grams per ton in typical rock."
                ),
                Question(
                    question = "What critical rare earth elements used in smartphone speakers and vibration motors can be recovered through e-waste recycling?",
                    firstResponse = "Neodymium and Dysprosium",
                    secondResponse = "Common sand",
                    thirdResponse = "Granite stone",
                    correctAnswer = 1,
                    hint = "Essential elements used in powerful miniature permanent magnets.",
                    explanation = "Neodymium and dysprosium are critical lanthanides used to manufacture ultra-strong NdFeB permanent magnets."
                ),
                Question(
                    question = "What major toxic heavy metal found in older cathode ray tubes and solder requires specialized containment during e-waste recycling?",
                    firstResponse = "Lead (Pb)",
                    secondResponse = "Pure calcium",
                    thirdResponse = "Vitamin C",
                    correctAnswer = 1,
                    hint = "A neurotoxic heavy metal with chemical symbol Pb.",
                    explanation = "Lead, historically used in electronics solder and CRT glass, is a neurotoxin that must be safely isolated during recycling."
                ),
                Question(
                    question = "What European Union regulatory directive obligates manufacturers to finance the collection and eco-friendly treatment of electronic waste?",
                    firstResponse = "The WEEE Directive (Waste Electrical and Electronic Equipment)",
                    secondResponse = "The Kyoto Protocol",
                    thirdResponse = "The Geneva Convention",
                    correctAnswer = 1,
                    hint = "Stands for Waste Electrical and Electronic Equipment.",
                    explanation = "The WEEE Directive mandates extended producer responsibility for collecting and recycling electronic equipment across the EU."
                )
            )
        ),
        ArticleItem(
            id = "en_waste_4",
            title = "Seaweed-Based Bioplastics: Marine Algae Packaging Dissolves in Warm Water in Weeks",
            sourceName = "Nature Sustainability",
            url = "https://www.nature.com/articles/s41893-024-01250-1",
            summary = "Biomaterial scientists engineer edible, moisture-resistant thin films derived from red and brown kelp alginates that biodegrade naturally without microplastics.",
            publishedDate = "Recent",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "What natural polysaccharide extracted from the cell walls of brown seaweeds is used to synthesize soluble bioplastics?",
                    firstResponse = "Alginate (alginic acid)",
                    secondResponse = "Polyvinyl chloride",
                    thirdResponse = "Asbestos",
                    correctAnswer = 1,
                    hint = "A gelatinous carbohydrate widely extracted from giant kelp that forms flexible polymers when crosslinked with calcium.",
                    explanation = "Alginates extracted from brown algae crosslink with divalent calcium ions to produce water-resistant, biodegradable films."
                ),
                Question(
                    question = "How long does a 100% seaweed-based bio-wrapper take to naturally decompose in home compost or soil?",
                    firstResponse = "Around 4 to 6 weeks",
                    secondResponse = "Over 1,000 years",
                    thirdResponse = "It never decomposes",
                    correctAnswer = 1,
                    hint = "Made from natural marine biomass, soil microorganisms digest it in roughly a month.",
                    explanation = "Pure seaweed bioplastics biodegrade in standard soil or home compost within 4 to 6 weeks, leaving zero toxic residues."
                ),
                Question(
                    question = "Unlike land-grown bioplastics made from corn (PLA) or sugarcane, what ecological advantage does farming marine seaweed offer?",
                    firstResponse = "It requires zero arable land, zero freshwater, zero chemical fertilizers, and absorbs ocean CO2",
                    secondResponse = "It requires clearing ancient rainforests",
                    thirdResponse = "It emits toxic chlorine gas",
                    correctAnswer = 1,
                    hint = "Seaweed grows entirely in ocean saltwater without competing with food crops for land or irrigation.",
                    explanation = "Seaweed cultivation needs no farmland, freshwater, or fertilizers, avoiding land-use conflicts associated with corn bioplastics."
                ),
                Question(
                    question = "What physical problem occurs when standard fossil-fuel plastic packaging is discarded in the natural environment?",
                    firstResponse = "It fragments into persistent microplastics and nanoplastics that contaminate ecosystems for centuries",
                    secondResponse = "It turns into fertile potting soil",
                    thirdResponse = "It instantly turns into pure water",
                    correctAnswer = 1,
                    hint = "Synthetic polymers do not biodegrade biologically; they merely break apart into tinier microscopic pieces.",
                    explanation = "Fossil plastics do not biologically decay, fragmenting under UV sunlight into hazardous microplastics that enter food chains."
                ),
                Question(
                    question = "What edible single-dose hydration pouch made of seaweed extract has been used to replace plastic water bottles at major city marathons?",
                    firstResponse = "Ooho edible seaweed membranes (Notpla)",
                    secondResponse = "Glass jars",
                    thirdResponse = "Aluminum soda cans",
                    correctAnswer = 1,
                    hint = "An innovative spherical edible pouch that runners can swallow whole or discard to naturally degrade.",
                    explanation = "Notpla's Ooho membranes are edible, spherical seaweed pods designed to dispense single servings of water without plastic bottles."
                )
            )
        ),
        ArticleItem(
            id = "en_waste_5",
            title = "Industrial Methanization: Turning Organic Food Waste into Biogas and Organic Biofertilizers",
            sourceName = "Science",
            url = "https://www.science.org/doi/10.1126/science.ade1100",
            summary = "Biochemical digestion plants transform municipal food scraps into renewable biomethane fuel, eliminating landfill methane emissions.",
            publishedDate = "Recent",
            themeTag = "dechets",
            curatedQuestions = listOf(
                Question(
                    question = "What biological process breaks down organic waste in the complete absence of oxygen to produce renewable methane biogas?",
                    firstResponse = "Anaerobic digestion (methanization)",
                    secondResponse = "Aerobic incineration",
                    thirdResponse = "Photosynthesis",
                    correctAnswer = 1,
                    hint = "Specialized anaerobic bacteria in sealed biodigesters convert organic matter into CH4 and CO2.",
                    explanation = "Anaerobic digestion is the breakdown of organic material by specialized microbes in an oxygen-free environment."
                ),
                Question(
                    question = "What is the primary combustible fuel component of purified biomethane gas?",
                    firstResponse = "Methane (CH4)",
                    secondResponse = "Carbon monoxide (CO)",
                    thirdResponse = "Helium (He)",
                    correctAnswer = 1,
                    hint = "The simplest hydrocarbon gas, composed of one carbon atom and four hydrogen atoms.",
                    explanation = "Methane (CH4) makes up 50% to 70% of raw biogas and can be scrubbed to >97% purity to inject into natural gas grids."
                ),
                Question(
                    question = "What nutrient-rich co-product left over after anaerobic digestion is applied to agricultural fields as natural fertilizer?",
                    firstResponse = "Digestate",
                    secondResponse = "Fly ash",
                    thirdResponse = "Plastic slag",
                    correctAnswer = 1,
                    hint = "The nutrient-dense mineralized organic residue rich in nitrogen, phosphorus, and potassium.",
                    explanation = "Digestate is the mineral-rich organic effluent left after biogas extraction, serving as an excellent replacement for chemical fertilizer."
                ),
                Question(
                    question = "Why is dumping organic food waste into unmanaged municipal landfills a major driver of global climate change?",
                    firstResponse = "Buried organic waste decomposes anaerobically beneath trash, releasing potent uncaptured methane gas",
                    secondResponse = "Food scraps create nuclear explosions",
                    thirdResponse = "Food waste freezes the atmosphere",
                    correctAnswer = 1,
                    hint = "Without oxygen, buried landfill waste emits methane—a greenhouse gas 28x more potent than CO2.",
                    explanation = "Organic waste in landfills decomposes without oxygen, producing fugitive methane emissions that escape directly into the atmosphere."
                ),
                Question(
                    question = "What fraction of all food produced globally for human consumption is estimated by the UN to be lost or wasted each year?",
                    firstResponse = "Approximately one-third (approx. 1.3 billion metric tons)",
                    secondResponse = "Less than 0.01%",
                    thirdResponse = "Exactly 99%",
                    correctAnswer = 1,
                    hint = "Roughly 30% of all food across farm, transport, retail, and household stages is thrown away.",
                    explanation = "The UN FAO estimates that roughly one-third (30–33%) of all food produced globally is lost or wasted annually."
                )
            )
        )
    )
}
