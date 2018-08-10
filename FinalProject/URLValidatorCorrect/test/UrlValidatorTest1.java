

import java.util.Random;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest1 extends TestCase {

String validTLDs[] = { "AAA",
		"AARP",
		"ABARTH",
		"ABB",
		"ABBOTT",
		"ABBVIE",
		"ABC",
		"ABLE",
		"ABOGADO",
		"ABUDHABI",
		"AC",
		"ACADEMY",
		"ACCENTURE",
		"ACCOUNTANT",
		"ACCOUNTANTS",
		"ACO",
		"ACTIVE",
		"ACTOR",
		"AD",
		"ADAC",
		"ADS",
		"ADULT",
		"AE",
		"AEG",
		"AERO",
		"AETNA",
		"AF",
		"AFAMILYCOMPANY",
		"AFL",
		//"AFRICA",
		"AG",
		"AGAKHAN",
		"AGENCY",
		"AI",
		"AIG",
		"AIGO",
		"AIRBUS",
		"AIRFORCE",
		"AIRTEL",
		"AKDN",
		"AL",
		"ALFAROMEO",
		"ALIBABA",
		"ALIPAY",
		"ALLFINANZ",
		"ALLSTATE",
		"ALLY",
		"ALSACE",
		"ALSTOM",
		"AM",
		"AMERICANEXPRESS",
		"AMERICANFAMILY",
		"AMEX",
		"AMFAM",
		"AMICA",
		"AMSTERDAM",
		"ANALYTICS",
		"ANDROID",
		"ANQUAN",
		"ANZ",
		"AO",
		"AOL",
		"APARTMENTS",
		"APP",
		"APPLE",
		"AQ",
		"AQUARELLE",
		"AR",
		//"ARAB",
		"ARAMCO",
		"ARCHI",
		"ARMY",
		"ARPA",
		"ART",
		"ARTE",
		"AS",
		"ASDA",
		"ASIA",
		"ASSOCIATES",
		"AT",
		"ATHLETA",
		"ATTORNEY",
		"AU",
		"AUCTION",
		"AUDI",
		"AUDIBLE",
		"AUDIO",
		"AUSPOST",
		"AUTHOR",
		"AUTO",
		"AUTOS",
		"AVIANCA",
		"AW",
		"AWS",
		"AX",
		"AXA",
		"AZ",
		"AZURE",
		"BA",
		"BABY",
		"BAIDU",
		"BANAMEX",
		"BANANAREPUBLIC",
		"BAND",
		"BANK",
		"BAR",
		"BARCELONA",
		"BARCLAYCARD",
		"BARCLAYS",
		"BAREFOOT",
		"BARGAINS",
		"BASEBALL",
		"BASKETBALL",
		"BAUHAUS",
		"BAYERN",
		"BB",
		"BBC",
		"BBT",
		"BBVA",
		"BCG",
		"BCN",
		"BD",
		"BE",
		"BEATS",
		"BEAUTY",
		"BEER",
		"BENTLEY",
		"BERLIN",
		"BEST",
		"BESTBUY",
		"BET",
		"BF",
		"BG",
		"BH",
		"BHARTI",
		"BI",
		"BIBLE",
		"BID",
		"BIKE",
		"BING",
		"BINGO",
		"BIO",
		"BIZ",
		"BJ",
		"BLACK",
		"BLACKFRIDAY",
		"BLANCO",
		"BLOCKBUSTER",
		"BLOG",
		"BLOOMBERG",
		"BLUE",
		"BM",
		"BMS",
		"BMW",
		"BN",
		"BNL",
		"BNPPARIBAS",
		"BO",
		"BOATS",
		"BOEHRINGER",
		"BOFA",
		"BOM",
		"BOND",
		"BOO",
		"BOOK",
		"BOOKING",
		"BOSCH",
		"BOSTIK",
		"BOSTON",
		"BOT",
		"BOUTIQUE",
		"BOX",
		"BR",
		"BRADESCO",
		"BRIDGESTONE",
		"BROADWAY",
		"BROKER",
		"BROTHER",
		"BRUSSELS",
		"BS",
		"BT",
		"BUDAPEST",
		"BUGATTI",
		"BUILD",
		"BUILDERS",
		"BUSINESS",
		"BUY",
		"BUZZ",
		"BV",
		"BW",
		"BY",
		"BZ",
		"BZH",
		"CA",
		"CAB",
		"CAFE",
		"CAL",
		"CALL",
		"CALVINKLEIN",
		"CAM",
		"CAMERA",
		"CAMP",
		"CANCERRESEARCH",
		"CANON",
		"CAPETOWN",
		"CAPITAL",
		"CAPITALONE",
		"CAR",
		"CARAVAN",
		"CARDS",
		"CARE",
		"CAREER",
		"CAREERS",
		"CARS",
		"CARTIER",
		"CASA",
		"CASE",
		"CASEIH",
		"CASH",
		"CASINO",
		"CAT",
		"CATERING",
		"CATHOLIC",
		"CBA",
		"CBN",
		"CBRE",
		"CBS",
		"CC",
		"CD",
		"CEB",
		"CENTER",
		"CEO",
		"CERN",
		"CF",
		"CFA",
		"CFD",
		"CG",
		"CH",
		"CHANEL",
		"CHANNEL",
		//"CHARITY",
		"CHASE",
		"CHAT",
		"CHEAP",
		"CHINTAI",
		"CHRISTMAS",
		"CHROME",
		"CHRYSLER",
		"CHURCH",
		"CI",
		"CIPRIANI",
		"CIRCLE",
		"CISCO",
		"CITADEL",
		"CITI",
		"CITIC",
		"CITY",
		"CITYEATS",
		"CK",
		"CL",
		"CLAIMS",
		"CLEANING",
		"CLICK",
		"CLINIC",
		"CLINIQUE",
		"CLOTHING",
		"CLOUD",
		"CLUB",
		"CLUBMED",
		"CM",
		"CN",
		"CO",
		"COACH",
		"CODES",
		"COFFEE",
		"COLLEGE",
		"COLOGNE",
		"COM",
		"COMCAST",
		"COMMBANK",
		"COMMUNITY",
		"COMPANY",
		"COMPARE",
		"COMPUTER",
		"COMSEC",
		"CONDOS",
		"CONSTRUCTION",
		"CONSULTING",
		"CONTACT",
		"CONTRACTORS",
		"COOKING",
		"COOKINGCHANNEL",
		"COOL",
		"COOP",
		"CORSICA",
		"COUNTRY",
		"COUPON",
		"COUPONS",
		"COURSES",
		"CR",
		"CREDIT",
		"CREDITCARD",
		"CREDITUNION",
		"CRICKET",
		"CROWN",
		"CRS",
		"CRUISE",
		"CRUISES",
		"CSC",
		"CU",
		"CUISINELLA",
		"CV",
		"CW",
		"CX",
		"CY",
		"CYMRU",
		"CYOU",
		"CZ",
		"DABUR",
		"DAD",
		"DANCE",
		"DATA",
		"DATE",
		"DATING",
		"DATSUN",
		"DAY",
		"DCLK",
		"DDS",
		"DE",
		"DEAL",
		"DEALER",
		"DEALS",
		"DEGREE",
		"DELIVERY",
		"DELL",
		"DELOITTE",
		"DELTA",
		"DEMOCRAT",
		"DENTAL",
		"DENTIST",
		"DESI",
		"DESIGN",
		"DEV",
		"DHL",
		"DIAMONDS",
		"DIET",
		"DIGITAL",
		"DIRECT",
		"DIRECTORY",
		"DISCOUNT",
		"DISCOVER",
		"DISH",
		"DIY",
		"DJ",
		"DK",
		"DM",
		"DNP",
		"DO",
		"DOCS",
		"DOCTOR",
		"DODGE",
		"DOG",
		"DOHA",
		"DOMAINS",
		"DOT",
		"DOWNLOAD",
		"DRIVE",
		"DTV",
		"DUBAI",
		"DUCK",
		"DUNLOP",
		"DUNS",
		"DUPONT",
		"DURBAN",
		"DVAG",
		"DVR",
		"DZ",
		"EARTH",
		"EAT",
		"EC",
		"ECO",
		"EDEKA",
		"EDU",
		"EDUCATION",
		"EE",
		"EG",
		"EMAIL",
		"EMERCK",
		"ENERGY",
		"ENGINEER",
		"ENGINEERING",
		"ENTERPRISES",
		"EPOST",
		"EPSON",
		"EQUIPMENT",
		"ER",
		"ERICSSON",
		"ERNI",
		"ES",
		"ESQ",
		"ESTATE",
		"ESURANCE",
		"ET",
		//"ETISALAT",
		"EU",
		"EUROVISION",
		"EUS",
		"EVENTS",
		"EVERBANK",
		"EXCHANGE",
		"EXPERT",
		"EXPOSED",
		"EXPRESS",
		"EXTRASPACE",
		"FAGE",
		"FAIL",
		"FAIRWINDS",
		"FAITH",
		"FAMILY",
		"FAN",
		"FANS",
		"FARM",
		"FARMERS",
		"FASHION",
		"FAST",
		"FEDEX",
		"FEEDBACK",
		"FERRARI",
		"FERRERO",
		"FI",
		"FIAT",
		"FIDELITY",
		"FIDO",
		"FILM",
		"FINAL",
		"FINANCE",
		"FINANCIAL",
		"FIRE",
		"FIRESTONE",
		"FIRMDALE",
		"FISH",
		"FISHING",
		"FIT",
		"FITNESS",
		"FJ",
		"FK",
		"FLICKR",
		"FLIGHTS",
		"FLIR",
		"FLORIST",
		"FLOWERS",
		"FLY",
		"FM",
		"FO",
		"FOO",
		"FOOD",
		"FOODNETWORK",
		"FOOTBALL",
		"FORD",
		"FOREX",
		"FORSALE",
		"FORUM",
		"FOUNDATION",
		"FOX",
		"FR",
		"FREE",
		"FRESENIUS",
		"FRL",
		"FROGANS",
		"FRONTDOOR",
		"FRONTIER",
		"FTR",
		"FUJITSU",
		"FUJIXEROX",
		"FUN",
		"FUND",
		"FURNITURE",
		"FUTBOL",
		"FYI",
		"GA",
		"GAL",
		"GALLERY",
		"GALLO",
		"GALLUP",
		"GAME",
		"GAMES",
		"GAP",
		"GARDEN",
		"GB",
		"GBIZ",
		"GD",
		"GDN",
		"GE",
		"GEA",
		"GENT",
		"GENTING",
		"GEORGE",
		"GF",
		"GG",
		"GGEE",
		"GH",
		"GI",
		"GIFT",
		"GIFTS",
		"GIVES",
		"GIVING",
		"GL",
		"GLADE",
		"GLASS",
		"GLE",
		"GLOBAL",
		"GLOBO",
		"GM",
		"GMAIL",
		"GMBH",
		"GMO",
		"GMX",
		"GN",
		"GODADDY",
		"GOLD",
		"GOLDPOINT",
		"GOLF",
		"GOO",
		"GOODHANDS",
		"GOODYEAR",
		"GOOG",
		"GOOGLE",
		"GOP",
		"GOT",
		"GOV",
		"GP",
		"GQ",
		"GR",
		"GRAINGER",
		"GRAPHICS",
		"GRATIS",
		"GREEN",
		"GRIPE",
		//"GROCERY",
		"GROUP",
		"GS",
		"GT",
		"GU",
		"GUARDIAN",
		"GUCCI",
		"GUGE",
		"GUIDE",
		"GUITARS",
		"GURU",
		"GW",
		"GY",
		"HAIR",
		"HAMBURG",
		"HANGOUT",
		"HAUS",
		"HBO",
		"HDFC",
		"HDFCBANK",
		"HEALTH",
		"HEALTHCARE",
		"HELP",
		"HELSINKI",
		"HERE",
		"HERMES",
		"HGTV",
		"HIPHOP",
		"HISAMITSU",
		"HITACHI",
		"HIV",
		"HK",
		"HKT",
		"HM",
		"HN",
		"HOCKEY",
		"HOLDINGS",
		"HOLIDAY",
		"HOMEDEPOT",
		"HOMEGOODS",
		"HOMES",
		"HOMESENSE",
		"HONDA",
		"HONEYWELL",
		"HORSE",
		"HOSPITAL",
		"HOST",
		"HOSTING",
		"HOT",
		"HOTELES",
		//"HOTELS",
		"HOTMAIL",
		"HOUSE",
		"HOW",
		"HR",
		"HSBC",
		"HT",
		"HU",
		"HUGHES",
		"HYATT",
		"HYUNDAI",
		"IBM",
		"ICBC",
		"ICE",
		"ICU",
		"ID",
		"IE",
		"IEEE",
		"IFM",
		"IKANO",
		"IL",
		"IM",
		"IMAMAT",
		"IMDB",
		"IMMO",
		"IMMOBILIEN",
		"IN",
		//"INC",
		"INDUSTRIES",
		"INFINITI",
		"INFO",
		"ING",
		"INK",
		"INSTITUTE",
		"INSURANCE",
		"INSURE",
		"INT",
		"INTEL",
		"INTERNATIONAL",
		"INTUIT",
		"INVESTMENTS",
		"IO",
		"IPIRANGA",
		"IQ",
		"IR",
		"IRISH",
		"IS",
		"ISELECT",
		"ISMAILI",
		"IST",
		"ISTANBUL",
		"IT",
		"ITAU",
		"ITV",
		"IVECO",
		"JAGUAR",
		"JAVA",
		"JCB",
		"JCP",
		"JE",
		"JEEP",
		"JETZT",
		"JEWELRY",
		"JIO",
		"JLC",
		"JLL",
		"JM",
		"JMP",
		"JNJ",
		"JO",
		"JOBS",
		"JOBURG",
		"JOT",
		"JOY",
		"JP",
		"JPMORGAN",
		"JPRS",
		"JUEGOS",
		"JUNIPER",
		"KAUFEN",
		"KDDI",
		"KE",
		"KERRYHOTELS",
		"KERRYLOGISTICS",
		"KERRYPROPERTIES",
		"KFH",
		"KG",
		"KH",
		"KI",
		"KIA",
		"KIM",
		"KINDER",
		"KINDLE",
		"KITCHEN",
		"KIWI",
		"KM",
		"KN",
		"KOELN",
		"KOMATSU",
		"KOSHER",
		"KP",
		"KPMG",
		"KPN",
		"KR",
		"KRD",
		"KRED",
		"KUOKGROUP",
		"KW",
		"KY",
		"KYOTO",
		"KZ",
		"LA",
		"LACAIXA",
		"LADBROKES",
		"LAMBORGHINI",
		"LAMER",
		"LANCASTER",
		"LANCIA",
		"LANCOME",
		"LAND",
		"LANDROVER",
		"LANXESS",
		"LASALLE",
		"LAT",
		"LATINO",
		"LATROBE",
		"LAW",
		"LAWYER",
		"LB",
		"LC",
		"LDS",
		"LEASE",
		"LECLERC",
		"LEFRAK",
		"LEGAL",
		"LEGO",
		"LEXUS",
		"LGBT",
		"LI",
		"LIAISON",
		"LIDL",
		"LIFE",
		"LIFEINSURANCE",
		"LIFESTYLE",
		"LIGHTING",
		"LIKE",
		"LILLY",
		"LIMITED",
		"LIMO",
		"LINCOLN",
		"LINDE",
		"LINK",
		"LIPSY",
		"LIVE",
		"LIVING",
		"LIXIL",
		"LK",
		//"LLC",
		"LOAN",
		"LOANS",
		"LOCKER",
		"LOCUS",
		"LOFT",
		"LOL",
		"LONDON",
		"LOTTE",
		"LOTTO",
		"LOVE",
		"LPL",
		"LPLFINANCIAL",
		"LR",
		"LS",
		"LT",
		"LTD",
		"LTDA",
		"LU",
		"LUNDBECK",
		"LUPIN",
		"LUXE",
		"LUXURY",
		"LV",
		"LY",
		"MA",
		"MACYS",
		"MADRID",
		"MAIF",
		"MAISON",
		"MAKEUP",
		"MAN",
		"MANAGEMENT",
		"MANGO",
		//"MAP",
		"MARKET",
		"MARKETING",
		"MARKETS",
		"MARRIOTT",
		"MARSHALLS",
		"MASERATI",
		"MATTEL",
		"MBA",
		"MC",
		"MCKINSEY",
		"MD",
		"ME",
		"MED",
		"MEDIA",
		"MEET",
		"MELBOURNE",
		"MEME",
		"MEMORIAL",
		"MEN",
		"MENU",
		//"MERCKMSD",
		"METLIFE",
		"MG",
		"MH",
		"MIAMI",
		"MICROSOFT",
		"MIL",
		"MINI",
		"MINT",
		"MIT",
		"MITSUBISHI",
		"MK",
		"ML",
		"MLB",
		"MLS",
		"MM",
		"MMA",
		"MN",
		"MO",
		"MOBI",
		"MOBILE",
		"MOBILY",
		"MODA",
		"MOE",
		"MOI",
		"MOM",
		"MONASH",
		"MONEY",
		"MONSTER",
		"MOPAR",
		"MORMON",
		"MORTGAGE",
		"MOSCOW",
		"MOTO",
		"MOTORCYCLES",
		"MOV",
		"MOVIE",
		"MOVISTAR",
		"MP",
		"MQ",
		"MR",
		"MS",
		"MSD",
		"MT",
		"MTN",
		"MTR",
		"MU",
		"MUSEUM",
		"MUTUAL",
		"MV",
		"MW",
		"MX",
		"MY",
		"MZ",
		"NA",
		"NAB",
		"NADEX",
		"NAGOYA",
		"NAME",
		"NATIONWIDE",
		"NATURA",
		"NAVY",
		"NBA",
		"NC",
		"NE",
		"NEC",
		"NET",
		"NETBANK",
		"NETFLIX",
		"NETWORK",
		"NEUSTAR",
		"NEW",
		"NEWHOLLAND",
		"NEWS",
		"NEXT",
		"NEXTDIRECT",
		"NEXUS",
		"NF",
		"NFL",
		"NG",
		"NGO",
		"NHK",
		"NI",
		"NICO",
		"NIKE",
		"NIKON",
		"NINJA",
		"NISSAN",
		"NISSAY",
		"NL",
		"NO",
		"NOKIA",
		"NORTHWESTERNMUTUAL",
		"NORTON",
		"NOW",
		"NOWRUZ",
		"NOWTV",
		"NP",
		"NR",
		"NRA",
		"NRW",
		"NTT",
		"NU",
		"NYC",
		"NZ",
		"OBI",
		"OBSERVER",
		"OFF",
		"OFFICE",
		"OKINAWA",
		"OLAYAN",
		"OLAYANGROUP",
		"OLDNAVY",
		"OLLO",
		"OM",
		"OMEGA",
		"ONE",
		"ONG",
		"ONL",
		"ONLINE",
		"ONYOURSIDE",
		"OOO",
		"OPEN",
		"ORACLE",
		"ORANGE",
		"ORG",
		"ORGANIC",
		"ORIGINS",
		"OSAKA",
		"OTSUKA",
		"OTT",
		"OVH",
		"PA",
		"PAGE",
		"PANASONIC",
		"PANERAI",
		"PARIS",
		"PARS",
		"PARTNERS",
		"PARTS",
		"PARTY",
		"PASSAGENS",
		"PAY",
		"PCCW",
		"PE",
		"PET",
		"PF",
		"PFIZER",
		"PG",
		"PH",
		"PHARMACY",
		//"PHD",
		"PHILIPS",
		"PHONE",
		"PHOTO",
		"PHOTOGRAPHY",
		"PHOTOS",
		"PHYSIO",
		"PIAGET",
		"PICS",
		"PICTET",
		"PICTURES",
		"PID",
		"PIN",
		"PING",
		"PINK",
		"PIONEER",
		"PIZZA",
		"PK",
		"PL",
		"PLACE",
		"PLAY",
		"PLAYSTATION",
		"PLUMBING",
		"PLUS",
		"PM",
		"PN",
		"PNC",
		"POHL",
		"POKER",
		"POLITIE",
		"PORN",
		"POST",
		"PR",
		"PRAMERICA",
		"PRAXI",
		"PRESS",
		"PRIME",
		"PRO",
		"PROD",
		"PRODUCTIONS",
		"PROF",
		"PROGRESSIVE",
		"PROMO",
		"PROPERTIES",
		"PROPERTY",
		"PROTECTION",
		"PRU",
		"PRUDENTIAL",
		"PS",
		"PT",
		"PUB",
		"PW",
		"PWC",
		"PY",
		"QA",
		"QPON",
		"QUEBEC",
		"QUEST",
		"QVC",
		"RACING",
		"RADIO",
		"RAID",
		"RE",
		"READ",
		"REALESTATE",
		"REALTOR",
		"REALTY",
		"RECIPES",
		"RED",
		"REDSTONE",
		"REDUMBRELLA",
		"REHAB",
		"REISE",
		"REISEN",
		"REIT",
		"RELIANCE",
		"REN",
		"RENT",
		"RENTALS",
		"REPAIR",
		"REPORT",
		"REPUBLICAN",
		"REST",
		"RESTAURANT",
		"REVIEW",
		"REVIEWS",
		"REXROTH",
		"RICH",
		"RICHARDLI",
		"RICOH",
		"RIGHTATHOME",
		"RIL",
		"RIO",
		"RIP",
		"RMIT",
		"RO",
		"ROCHER",
		"ROCKS",
		"RODEO",
		"ROGERS",
		"ROOM",
		"RS",
		"RSVP",
		"RU",
		//"RUGBY",
		"RUHR",
		"RUN",
		"RW",
		"RWE",
		"RYUKYU",
		"SA",
		"SAARLAND",
		"SAFE",
		"SAFETY",
		"SAKURA",
		"SALE",
		"SALON",
		"SAMSCLUB",
		"SAMSUNG",
		"SANDVIK",
		"SANDVIKCOROMANT",
		"SANOFI",
		"SAP",
		"SARL",
		"SAS",
		"SAVE",
		"SAXO",
		"SB",
		"SBI",
		"SBS",
		"SC",
		"SCA",
		"SCB",
		"SCHAEFFLER",
		"SCHMIDT",
		"SCHOLARSHIPS",
		"SCHOOL",
		"SCHULE",
		"SCHWARZ",
		"SCIENCE",
		"SCJOHNSON",
		"SCOR",
		"SCOT",
		"SD",
		"SE",
		//"SEARCH",
		"SEAT",
		"SECURE",
		"SECURITY",
		"SEEK",
		"SELECT",
		"SENER",
		"SERVICES",
		"SES",
		"SEVEN",
		"SEW",
		"SEX",
		"SEXY",
		"SFR",
		"SG",
		"SH",
		"SHANGRILA",
		"SHARP",
		"SHAW",
		"SHELL",
		"SHIA",
		"SHIKSHA",
		"SHOES",
		"SHOP",
		"SHOPPING",
		"SHOUJI",
		"SHOW",
		"SHOWTIME",
		"SHRIRAM",
		"SI",
		"SILK",
		"SINA",
		"SINGLES",
		"SITE",
		"SJ",
		"SK",
		"SKI",
		"SKIN",
		"SKY",
		"SKYPE",
		"SL",
		"SLING",
		"SM",
		"SMART",
		"SMILE",
		"SN",
		"SNCF",
		"SO",
		"SOCCER",
		"SOCIAL",
		"SOFTBANK",
		"SOFTWARE",
		"SOHU",
		"SOLAR",
		"SOLUTIONS",
		"SONG",
		"SONY",
		"SOY",
		"SPACE",
		"SPIEGEL",
		//"SPORT",
		"SPOT",
		"SPREADBETTING",
		"SR",
		"SRL",
		"SRT",
		"ST",
		"STADA",
		"STAPLES",
		"STAR",
		"STARHUB",
		"STATEBANK",
		"STATEFARM",
		"STATOIL",
		"STC",
		"STCGROUP",
		"STOCKHOLM",
		"STORAGE",
		"STORE",
		"STREAM",
		"STUDIO",
		"STUDY",
		"STYLE",
		"SU",
		"SUCKS",
		"SUPPLIES",
		"SUPPLY",
		"SUPPORT",
		"SURF",
		"SURGERY",
		"SUZUKI",
		"SV",
		"SWATCH",
		"SWIFTCOVER",
		"SWISS",
		"SX",
		"SY",
		"SYDNEY",
		"SYMANTEC",
		"SYSTEMS",
		"SZ",
		"TAB",
		"TAIPEI",
		"TALK",
		"TAOBAO",
		"TARGET",
		"TATAMOTORS",
		"TATAR",
		"TATTOO",
		"TAX",
		"TAXI",
		"TC",
		"TCI",
		"TD",
		"TDK",
		"TEAM",
		"TECH",
		"TECHNOLOGY",
		"TEL",
		"TELECITY",
		"TELEFONICA",
		"TEMASEK",
		"TENNIS",
		"TEVA",
		"TF",
		"TG",
		"TH",
		"THD",
		"THEATER",
		"THEATRE",
		"TIAA",
		"TICKETS",
		"TIENDA",
		"TIFFANY",
		"TIPS",
		"TIRES",
		"TIROL",
		"TJ",
		"TJMAXX",
		"TJX",
		"TK",
		"TKMAXX",
		"TL",
		"TM",
		"TMALL",
		"TN",
		"TO",
		"TODAY",
		"TOKYO",
		"TOOLS",
		"TOP",
		"TORAY",
		"TOSHIBA",
		"TOTAL",
		"TOURS",
		"TOWN",
		"TOYOTA",
		"TOYS",
		"TR",
		"TRADE",
		"TRADING",
		"TRAINING",
		"TRAVEL",
		"TRAVELCHANNEL",
		"TRAVELERS",
		"TRAVELERSINSURANCE",
		"TRUST",
		"TRV",
		"TT",
		"TUBE",
		"TUI",
		"TUNES",
		"TUSHU",
		"TV",
		"TVS",
		"TW",
		"TZ",
		"UA",
		"UBANK",
		"UBS",
		"UCONNECT",
		"UG",
		"UK",
		"UNICOM",
		"UNIVERSITY",
		"UNO",
		"UOL",
		"UPS",
		"US",
		"UY",
		"UZ",
		"VA",
		"VACATIONS",
		"VANA",
		"VANGUARD",
		"VC",
		"VE",
		"VEGAS",
		"VENTURES",
		"VERISIGN",
		"VERSICHERUNG",
		"VET",
		"VG",
		"VI",
		"VIAJES",
		"VIDEO",
		"VIG",
		"VIKING",
		"VILLAS",
		"VIN",
		"VIP",
		"VIRGIN",
		"VISA",
		"VISION",
		"VISTA",
		"VISTAPRINT",
		"VIVA",
		"VIVO",
		"VLAANDEREN",
		"VN",
		"VODKA",
		"VOLKSWAGEN",
		"VOLVO",
		"VOTE",
		"VOTING",
		"VOTO",
		"VOYAGE",
		"VU",
		"VUELOS",
		"WALES",
		"WALMART",
		"WALTER",
		"WANG",
		"WANGGOU",
		"WARMAN",
		"WATCH",
		"WATCHES",
		"WEATHER",
		"WEATHERCHANNEL",
		"WEBCAM",
		"WEBER",
		"WEBSITE",
		"WED",
		"WEDDING",
		"WEIBO",
		"WEIR",
		"WF",
		"WHOSWHO",
		"WIEN",
		"WIKI",
		"WILLIAMHILL",
		"WIN",
		"WINDOWS",
		"WINE",
		"WINNERS",
		"WME",
		"WOLTERSKLUWER",
		"WOODSIDE",
		"WORK",
		"WORKS",
		"WORLD",
		"WOW",
		"WS",
		"WTC",
		"WTF",
		"XBOX",
		"XEROX",
		"XFINITY",
		"XIHUAN",
		"XIN",
		//"XN",
		"XXX",
		"XYZ",
		"YACHTS",
		"YAHOO",
		"YAMAXUN",
		"YANDEX",
		"YE",
		"YODOBASHI",
		"YOGA",
		"YOKOHAMA",
		"YOU",
		"YOUTUBE",
		"YT",
		"YUN",
		"ZA",
		"ZAPPOS",
		"ZARA",
		"ZERO",
		"ZIP",
		"ZIPPO",
		"ZM",
		"ZONE",
		"ZUERICH",
		"ZW"
};	
	
	
	   String lowercase = "abcdefghijklmnopqrstuvwxyz";
	   String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   String numbers = "0123456789";
	   String punctuation = "`~!@#$%^&*()-_+=\\|{}[]';:/?.,><\""; 
	   String URI_permitted_chars = "!$&'()*+,;=";
	   
	   Random random = new Random();
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	
	   public static final int INVALID_SCHEME_CHANCE = 25;		// % chance of invalid scheme
	   public static final int INVALID_AUTHORITY_CHANCE = 25; 	// % chance of invalid authority
	   
	   
   public UrlValidatorTest1(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   //Kkqmzg://ml8yuaZ1AY1Tb16bYE.jgFBsuvs6eie06eonRwIDRGGiEqMXs3uwKPveTKdCg3OPlmsDAle0jN.zLe97brpa.iO1jV-wDUW4yHDNrimsM0cHVQtAdMT60IqFadL3c.pqqc2zYe8JNPVo-JZAqZ5d5fT.bjOuFh3.EFIN6hd5eER0Q3U27IsYBXxyb2yVZBX4Wz.CHARITY
	   boolean val = urlVal.isValid("Kkqmzg://ml8yuaZ1AY1Tb16bYE.jgFBsuvs6eie06eonRwIDRGGiEqMXs3uwKPveTKdCg3OPlmsDAle0jN.zLe97brpa.iO1jV-wDUW4yHDNrimsM0cHVQtAdMT60IqFadL3c.pqqc2zYe8JNPVo-JZAqZ5d5fT.bjOuFh3.EFIN6hd5eER0Q3U27IsYBXxyb2yVZBX4Wz.Com");
	   //assertTrue(val);
	   
	   String[] invalidList = new String[validTLDs.length];
	   int index = 0;
	   
	   for(int i = 0; i < validTLDs.length; i++)
	   {
		   val = urlVal.isValid("http://www.google." + validTLDs[i]);
		   if(!val)
		   {
			   invalidList[index] = validTLDs[i];
			   index++;
		   }
	   }
	   
	   
	   String[] finalList = new String[index];
	   
	   System.out.println("*******invalid tlds *************************");
	   
	   for(int i = 0; i < index; i++)
		   //finalList[i] = invalidList[i];
		   System.out.println(invalidList[i]);
	   
	   System.out.println("*******invalid tlds *************************");
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

	  UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 
	/*  From https://en.wikipedia.org/wiki/Uniform_Resource_Identifier 
	 * 5 basic parts to a valid url:
	 *   scheme: http, https, ftp, etc
	 *   	- cannot be empty
	 *   	- must be followed by colon (:)
	 *   	- letters, digits, '+', '.', '-'
	 *   authority: host name or ip number 
	 *   	- optional
	 *   	- optional user info section    jon:Pword@google.com
	 *   		- username 
	 *   		- optional password preceded by :
	 *   		- ! $ & ' ( ) * + , ; =  are valid
	 *   	- preceded by '//'
	 *  
	 *   	- optional port number
	 *   	- ip4 addresses must be dot notation
	 *   	- ip6 addresses must be inside brackets []
	 *   path:  /what/ever
	 *   	- may be empty
	 *   	- if authority is present it must begin with /
	 *   	- if no authority it cannot begin with //
	 *   	- can contain //
	 *   query: ?query=term&thing
	 *   	- optional
	 *   	- begins with ?
	 *   	- not well defined
	 * 	 fragment: #fragment
	 * 		- preceded by #
	 * 		
	 * 
	 *   other rules:
	 *   	: / ? # [ ] @ are reserved and must be percent encoded
	 *   	
	 */
	  

	  // possible input problems:
	   
	 //1. NULL input
	   boolean val = urlVal.isValid(null);
	   assertTrue(!val);
	   
	 // 2. Empty input string
	   val = urlVal.isValid("");
	   assertTrue(!val);
	   
	 // 3. valid schemes
	   val = urlVal.isValid("http://google.com");
	   assertTrue(val);
	   
	   val = urlVal.isValid("https:");
	//   assertTrue(val);
	   
	   val = urlVal.isValid("ftp:");
	//   assertTrue(val);
	   
	   // invalid schemes
	   val = urlVal.isValid("<>[]:");
	   assertTrue(!val);
	   
	   val = urlVal.isValid(":");
	   assertTrue(!val);
	   
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
  
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	  
	   
	   // build our random url
	   ResultPair SchemePair = generateScheme();
	   ResultPair AuthorityPair = generateAuthority();
	   ResultPair PathPair = generatePath();
	   ResultPair QueryPair = generateQuery();
	   ResultPair FragmentPair = generateFragment();
	   
	   String url = "";
	   boolean result = true;
	   boolean expected = true;
	   
	   for(int i = 0; i < 1000000; i++)
	   {
		   // build our random url
		   SchemePair = generateScheme();
		   AuthorityPair = generateAuthority();
		   PathPair = generatePath();
		   QueryPair = generateQuery();
		   FragmentPair = generateFragment();
		   url = SchemePair.item + AuthorityPair.item + PathPair.item + QueryPair.item + FragmentPair.item;
	   
	
	   
		   	//System.out.println(url);
	   		result = urlVal.isValid( url);
	   		expected = SchemePair.valid && AuthorityPair.valid && PathPair.valid && QueryPair.valid && FragmentPair.valid;
	   		if(result != expected)
	   			outputTestInfo(url, SchemePair, AuthorityPair, PathPair, QueryPair, FragmentPair);
	   		assertTrue(result == expected);
	   		System.out.println(i);
	   }
	   
   }
   
   
   // output test info for debug
   public void outputTestInfo(String url, ResultPair SchemePair, ResultPair AuthorityPair, ResultPair PathPair, ResultPair QueryPair, ResultPair FragmentPair)
   {
	   System.out.println("---------- TEST FAILED -----------");
	   System.out.println("url: " + url);
	   
	   // check scheme
	   
	   //remove :// from end if present
	   String scheme = SchemePair.item;
	   if(scheme.substring(scheme.length() - 3).contains("://"))
		   scheme = scheme.substring(0, scheme.length() - 3);
	   
	   if(urlVal.isValidScheme(scheme) != SchemePair.valid)
		   System.out.println("SchemePair: "+ SchemePair.valid + " -- " + scheme );
	   
	   // check authority
	   if(urlVal.isValidAuthority(AuthorityPair.item)!= AuthorityPair.valid )
	   		System.out.println("AuthorityPair: "+ AuthorityPair.valid + " -- " + AuthorityPair.item );
	   
	   // check path
	   if(urlVal.isValidPath(PathPair.item) != PathPair.valid )
		   System.out.println("PathPair: "+ PathPair.valid + " -- " + PathPair.item );
	   
	   // check query
	   if(urlVal.isValidQuery(QueryPair.item) != QueryPair.valid )
		   System.out.println("QueryPair: "+ QueryPair.valid + " -- " + QueryPair.item );
	   
	   // check fragment
	   if(urlVal.isValidFragment(FragmentPair.item) != FragmentPair.valid )
		   System.out.println("FragmentPair: "+ FragmentPair.valid + " -- " + FragmentPair.item );
	   
	   System.out.println("----------------------------------");
   }
   // generate valid or invalid scheme
   ResultPair generateScheme()
   {

	   boolean schemeValid = true;

	   
	   // create a valid scheme  
	   String scheme = randoString(uppercase + lowercase + numbers, 20); 
	   String endScheme = randoString("+-.", 1);
	   
	   // if scheme is only +, - or . then it's invalid
	   if(scheme.length() == 0 && endScheme.length() > 0)
		   schemeValid = false;
	   
	   
	   // invalid if first char is number
	   if(scheme.length() > 0 && numbers.contains(Character.toString(scheme.charAt(0))))
			   schemeValid = false;
	   
	   if(random.nextInt(100) < INVALID_SCHEME_CHANCE)
	   {
		   schemeValid = false;
		   
		   String appendage = randoString(uppercase + lowercase + numbers, 25);
		   
		   // prevent appendage from being valid
		   while(appendage.contains("://"))
			   appendage = randoString(uppercase + lowercase + numbers, 25);
		   
		   scheme += appendage;
	   }
	   else
	   {
		   // "://" Is and invalid scheme
		   if(scheme.length() == 0)
			   schemeValid = false;
		   
		   scheme += "://";
	   }   
	   return new ResultPair(scheme, schemeValid);
   }
   
   
   // generate valid or invalid authority
   ResultPair generateAuthority()
   {
	   boolean authorityValid = true;
	   
	   // create a valid authority
	   
	   String authority = "";
	   
	   // generate user info?
	   if(random.nextInt(100) < 20)
	   {
	//	   authority = randoString(uppercase + lowercase + numbers + URI_permitted_chars, 257);
		   
		   // add optional password?
		   if(random.nextInt(100) < 25)
		   {
			   // username without pass is invalid
			   if(authority.length() == 0)
			   {
		//		   System.out.println("false from authority.length == 0");
				   authorityValid = false;
			   }
			   String password = ":" + randoString(uppercase + lowercase + numbers + URI_permitted_chars, 257);
			   authority += password;
			   
		   }
		   
		   if(authority.length() == 0)
		   {
	//		   System.out.println("false from second authority.length == 0");
			   authorityValid = false;
		   }
			authority += "@";
	   }
	   
	  //switch(4) 
	   switch(random.nextInt(4))
	   
	   {
	   // valid ip4
	   	case 0: 
		   authority += generateIP4();
		   break;
	   	case 1:
	   	// valid ip6 -- note ip6 cannot have user info so it is removed
	   		authorityValid = true;
	   		authority = "[" + generateIP6() + "]";
	   		
	   		int randoInvalidBrackets = random.nextInt(100);
	   		
	   		if(randoInvalidBrackets < 3)
	   		{
	   			authority = randoString(numbers + uppercase + lowercase, 1) + authority.substring(1);
	   			authorityValid = false;
	   		}
	   		else if(randoInvalidBrackets < 6)
	   		{
	   			authority =  authority.substring(0, authority.length() - 2) + randoString(numbers + uppercase + lowercase, 1);
	   			authorityValid = false;
	   		}
	   		else if(randoInvalidBrackets < 9)
	   		{
	   			authority = randoString(numbers + uppercase + lowercase, 1) + authority.substring(1, authority.length() - 2) + randoString(numbers + uppercase + lowercase, 1);
	   			authorityValid = false;
	   		}
	   			
	   		
	   		
	   		break;
	   	
	   	// default generate domain string (may be valid or invalid)
	   	default:
	   		ResultPair temp = generateDomain();
	   		authority += temp.item;
	   		authorityValid = authorityValid && temp.valid;
	   		
	   			
	   }
	
	   return new ResultPair(authority, authorityValid);
   }
   
   
   // generate valid ip4 address
   String generateIP4()
   {
	   String IP4 = "";
	   
		   // generate valid ip4 address
	   for(int i = 0; i < 4; i++)
	   {
		   IP4 += Integer.toString(random.nextInt(256));
			   
		   if(i < 3) IP4 += ".";
	   }
	 
	   return IP4;
   }
   
   
   // generate valid ip6 address
   String generateIP6()
   {
	   String ip6 = "";
	   
	   // generate valid ip6 address
	   for(int i = 0; i < 8; i++)
	   {
		   ip6 += Integer.toHexString((random.nextInt(65536)));
		   
		   if(i < 7) ip6 += ":";
	   }
	   
	   return ip6;
   }
   
   
   // return valid top level domain from list
  String generateValidTLD()
  {
	  int index = random.nextInt(validTLDs.length);
	  return validTLDs[index];
  }
   
   // generate valid domain
  ResultPair generateDomain()
   {
	   String domain = "";
	   boolean domainValid = true;
	   
	   int parts = random.nextInt(10);
	   
	   // check if at least one part
	   if(parts == 0) 
	   {
		//   System.out.println("false from parts == 0");
		   domainValid = false;
	   }
	   
	   int segmentLength = 69;
	   String temp = "";
	   
	   for(int i = 0; i < parts; i++)
	   {
		   temp = randoString(uppercase + lowercase + numbers + "-", segmentLength);
		 //  System.out.println("temp.length(): " + Integer.toString(temp.length()));
			domain += temp;
		   // check length
		   if(temp.length() == 0 || temp.length() > 63)
		   {
			   domainValid = false;
			//   System.out.println("false from temp.length();: " + Integer.toString(temp.length()));
		   }
		   
		   // check if '-' at start or end
		   if((temp.length() > 0) && ((temp.charAt(0) == '-')  || (temp.charAt(temp.length() - 1) == '-')))
		   {
			   domainValid = false;
			  // System.out.println("false from '-'");
		   }
		  
		   domain += ".";
	   }
	   
	 //if(domain.length()  0)
	   //domain = domain.substring(0,  domain.length() - 1);
	   
		domain += generateValidTLD();
		 
		 
		 
	   if(domain.length() > 253 || domain.length() == 0 || domain.contains("..") || !domain.contains("."))
	   {
		 //  System.out.println("false from total length or .. or not .");
		   domainValid = false;
	   }
	  
	  // System.out.println(domain);
	   return new ResultPair(domain, domainValid);
   }
   
   // generate valid or invalid path
   public ResultPair generatePath()
   {
	   String path = "";
	   boolean pathValid = true;
	   
	   return new ResultPair(path, pathValid);
   }
   
   
   // generate valid or invalid query
   public ResultPair generateQuery()
   {
	   String query = "";
	   boolean queryValid = true;
	   
	   return new ResultPair(query, queryValid);
   }
   
   // generate valid or invalid fragment
   public ResultPair generateFragment()
   {
	   String fragment = "";
	   boolean fragmentValid = true;
	   
	   return new ResultPair(fragment, fragmentValid);
   }
   
   // generates random string from validChars
   public String randoString(String validChars, int limit)
   {
	   String retString = "";
	   
	   Random random = new Random();
	   
	   int numChars = random.nextInt(limit + 1);
	   int randPos = -1;
	   
	   for(int i = 0; i < numChars; i++)
	   {
		   randPos = random.nextInt(validChars.length());
		   retString += Character.toString(validChars.charAt(randPos));
		   
	   }
	   
	  
	   return retString;
   }
   

}


