package com.example.paocards.data

data class CardEntry(
    val card: String, val rank: String, val suit: String, val suitSymbol: String, val color: String,
    val category: String, val person: String, val action: String, val objectName: String,
    val bio: String, val source: String, val emoji: String, val mnemonic: String
)

val CARD_DATA: List<CardEntry> = listOf(
    // ♥ HEARTS - FAMILY
    CardEntry("A♥", "Ace", "Hearts", "♥", "Red", "Family", "Grandma Batiem", "Rocking", "a cradle", "The matriarch who raised us.", "Real Family", "👵🍼", "The A is a pointed peak, like a rocking cradle. Imagine Grandma Batiem rocking a cradle. Smell lavender. Hear the cradle creak."),
    CardEntry("2♥", "Two", "Hearts", "♥", "Red", "Family", "Dad William", "Hammering", "a nail", "Our father, a strong provider.", "Real Family", "👨‍🔧🔨", "The 2 is a swan neck, like a hammer hook. Imagine Dad William hammering a nail. Smell sawdust. Hear the thunk-thunk."),
    CardEntry("3♥", "Three", "Hearts", "♥", "Red", "Family", "Mum Selina", "Gardening", "a rose", "Our mother, full of love.", "Real Family", "👩‍🌾🌹", "The 3 is a rose stem curl. Imagine Mum Selina gardening. Smell wet soil. Feel the thorn prick."),
    CardEntry("4♥", "Four", "Hearts", "♥", "Red", "Family", "Jesca", "Reading", "a novel", "Our eldest sister, wise and smart.", "Real Family", "👩📖", "The 4 is a flag. Imagine Jesca reading a novel. Smell old paper. Hear pages turn."),
    CardEntry("5♥", "Five", "Hearts", "♥", "Red", "Family", "Patty", "Sewing", "a dress", "Our sister, creative with her hands.", "Real Family", "🧵👗", "The 5 is a hook. Imagine Patty sewing a dress. Smell fabric. Hear the needle click."),
    CardEntry("6♥", "Six", "Hearts", "♥", "Red", "Family", "Dayc", "Painting", "a canvas", "Our sister, artistic and colorful.", "Real Family", "🎨🖼️", "The 6 is a loop. Imagine Dayc painting a canvas. Smell oil paint. Feel the brush."),
    CardEntry("7♥", "Seven", "Hearts", "♥", "Red", "Family", "Abby", "Laughing", "a joke book", "Our sister, always full of joy.", "Real Family", "😂📕", "The 7 is a bar. Imagine Abby laughing at a joke book. Hear her laugh echo."),
    CardEntry("8♥", "Eight", "Hearts", "♥", "Red", "Family", "Kiling' (You)", "Writing", "a letter", "The only son, writing his story.", "Real Family", "✍️📝", "The 8 is two loops. Imagine Kiling' writing a letter. Smell fresh ink. Feel the pen."),
    CardEntry("9♥", "Nine", "Hearts", "♥", "Red", "Family", "Faith", "Praying", "a rosary", "Our sister, deeply spiritual.", "Real Family", "🙏📿", "The 9 is a tail. Imagine Faith praying with a rosary. Hear the beads click."),
    CardEntry("10♥", "Ten", "Hearts", "♥", "Red", "Family", "Yukaa", "Hugging", "a bouquet", "My wife, my love.", "Real Family", "🤗💐", "The 10 is a circle and line. Imagine Yukaa hugging me with a bouquet. Smell roses."),
    CardEntry("J♥", "Jack", "Hearts", "♥", "Red", "Family", "Max", "Playing", "a toy car", "My son, full of life.", "Real Family", "👦🚗", "The J is a hook. Imagine Max playing with a toy car. Hear vroom-vroom."),
    CardEntry("Q♥", "Queen", "Hearts", "♥", "Red", "Family", "Kiropi", "Climbing", "a tree", "Nephew, adventurous.", "Real Family", "🧒🌳", "The Q is a circle and tail. Imagine Kiropi climbing a tree. Smell leaves."),
    CardEntry("K♥", "King", "Hearts", "♥", "Red", "Family", "Kimutetee", "Kicking", "a soccer ball", "Nephew, energetic boy.", "Real Family", "👦⚽", "The K is a fork. Imagine Kimutetee kicking a soccer ball. Hear the thump."),

    // ♦ DIAMONDS - CELEBRITIES
    CardEntry("A♦", "Ace", "Diamonds", "♦", "Red", "Celebrity", "Oprah Winfrey", "Interviewing", "a red chair", "Talk show legend.", "TV Host", "🎤🪑", "The A is a peak. Imagine Oprah interviewing in a red chair. Smell expensive perfume."),
    CardEntry("2♦", "Two", "Diamonds", "♦", "Red", "Celebrity", "Elvis Presley", "Strutting", "a leather jacket", "The King of Rock.", "Music", "🕺🧥", "The 2 is a swan. Imagine Elvis strutting in a leather jacket. Hear the guitar."),
    CardEntry("3♦", "Three", "Diamonds", "♦", "Red", "Celebrity", "Madonna", "Posing", "a cone bra", "Queen of Pop.", "Music", "💃👙", "The 3 is a curve. Imagine Madonna posing in a cone bra. Feel the stage lights."),
    CardEntry("4♦", "Four", "Diamonds", "♦", "Red", "Celebrity", "Prince", "Strumming", "a purple guitar", "The Purple One.", "Music", "🎸💜", "The 4 is a flag. Imagine Prince strumming a purple guitar. Smell his cologne."),
    CardEntry("5♦", "Five", "Diamonds", "♦", "Red", "Celebrity", "David Bowie", "Chameleoning", "a flash of glitter", "The chameleon of rock.", "Music", "⚡✨", "The 5 is a hook. Imagine Bowie chameleoning with glitter. See the flash."),
    CardEntry("6♦", "Six", "Diamonds", "♦", "Red", "Celebrity", "Lady Gaga", "Wearing", "a meat dress", "Pop icon.", "Music", "🥩👗", "The 6 is a loop. Imagine Gaga wearing a meat dress. Smell the raw meat."),
    CardEntry("7♦", "Seven", "Diamonds", "♦", "Red", "Celebrity", "Rihanna", "Sparkling", "a diamond choker", "Singer and mogul.", "Music", "💎📿", "The 7 is a bar. Imagine Rihanna sparkling in a diamond choker. See the shine."),
    CardEntry("8♦", "Eight", "Diamonds", "♦", "Red", "Celebrity", "Taylor Swift", "Songwriting", "a journal", "Pop star.", "Music", "📝🎵", "The 8 is loops. Imagine Taylor writing in a journal. Smell the paper."),
    CardEntry("9♦", "Nine", "Diamonds", "♦", "Red", "Celebrity", "Marilyn Monroe", "Standing", "a white dress", "Hollywood icon.", "Film", "👗💨", "The 9 is a tail. Imagine Marilyn standing over a grate in a white dress. Feel the wind."),
    CardEntry("10♦", "Ten", "Diamonds", "♦", "Red", "Celebrity", "Frank Sinatra", "Crooning", "a whiskey glass", "Chairman of the Board.", "Music", "🥃🎤", "The 10 is a circle. Imagine Sinatra crooning with whiskey. Smell the oak."),
    CardEntry("J♦", "Jack", "Diamonds", "♦", "Red", "Celebrity", "Justin Bieber", "Skateboarding", "a snapback", "Pop star.", "Music", "🛹🧢", "The J is a hook. Imagine Bieber skateboarding in a snapback. Hear the wheels."),
    CardEntry("Q♦", "Queen", "Diamonds", "♦", "Red", "Celebrity", "Celine Dion", "Belting", "a heart necklace", "Powerhouse vocalist.", "Music", "💖🎶", "The Q is a circle. Imagine Celine belting with a heart necklace. Hear the high note."),
    CardEntry("K♦", "King", "Diamonds", "♦", "Red", "Celebrity", "Cher", "Wearing", "a bob wig", "Pop legend.", "Music", "💇‍♀️👑", "The K is a fork. Imagine Cher in a bob wig. See her turn back time."),

    // ♣ CLUBS - ATHLETES
    CardEntry("A♣", "Ace", "Clubs", "♣", "Black", "Athlete", "Muhammad Ali", "Punching", "a boxing glove", "The Greatest.", "Boxing", "🥊✊", "The A is a peak. Imagine Ali punching with a glove. Smell the sweat."),
    CardEntry("2♣", "Two", "Clubs", "♣", "Black", "Athlete", "Usain Bolt", "Sprinting", "a lightning pose", "Fastest man alive.", "Track", "🏃⚡", "The 2 is a swan. Imagine Bolt sprinting in a lightning pose. Feel the wind."),
    CardEntry("3♣", "Three", "Clubs", "♣", "Black", "Athlete", "Cristiano Ronaldo", "Kicking", "a soccer ball", "Football superstar.", "Soccer", "⚽🦵", "The 3 is a curve. Imagine Ronaldo kicking a soccer ball. Hear the thump."),
    CardEntry("4♣", "Four", "Clubs", "♣", "Black", "Athlete", "Lionel Messi", "Dribbling", "a golden boot", "Football genius.", "Soccer", "👟🥇", "The 4 is a flag. Imagine Messi dribbling with a golden boot. See the shine."),
    CardEntry("5♣", "Five", "Clubs", "♣", "Black", "Athlete", "Serena Williams", "Serving", "a tennis racket", "Tennis legend.", "Tennis", "🎾💪", "The 5 is a hook. Imagine Serena serving with a racket. Hear the grunt."),
    CardEntry("6♣", "Six", "Clubs", "♣", "Black", "Athlete", "Conor McGregor", "Strutting", "a UFC belt", "MMA star.", "MMA", "🥋🏆", "The 6 is a loop. Imagine McGregor strutting with a UFC belt. Hear the crowd."),
    CardEntry("7♣", "Seven", "Clubs", "♣", "Black", "Athlete", "Tom Brady", "Throwing", "a football", "NFL GOAT.", "Football", "🏈🎯", "The 7 is a bar. Imagine Brady throwing a football. Feel the spiral."),
    CardEntry("8♣", "Eight", "Clubs", "♣", "Black", "Athlete", "Kylian Mbappé", "Running", "a soccer cleat", "French prodigy.", "Soccer", "👟🏃", "The 8 is loops. Imagine Mbappé running in a cleat. Feel the grass."),
    CardEntry("9♣", "Nine", "Clubs", "♣", "Black", "Athlete", "Ronda Rousey", "Arm-barring", "a UFC trophy", "MMA champion.", "MMA", "🤼‍♀️🏆", "The 9 is a tail. Imagine Rousey arm-barring for a trophy. Hear the tap."),
    CardEntry("10♣", "Ten", "Clubs", "♣", "Black", "Athlete", "Arnold Schwarzenegger", "Lifting", "a golden trophy", "Bodybuilder and actor.", "Bodybuilding", "💪🏆", "The 10 is a circle. Imagine Arnold lifting a golden trophy. Smell the oil."),
    CardEntry("J♣", "Jack", "Clubs", "♣", "Black", "Athlete", "Rafael Nadal", "Swinging", "a clay-court racket", "Tennis champion.", "Tennis", "🎾🟠", "The J is a hook. Imagine Nadal swinging on clay. Smell the dust."),
    CardEntry("Q♣", "Queen", "Clubs", "♣", "Black", "Athlete", "Simone Biles", "Flipping", "a balance beam", "Gymnastics GOAT.", "Gymnastics", "🤸‍♀️⚖️", "The Q is a circle. Imagine Biles flipping on a beam. Feel the balance."),
    CardEntry("K♣", "King", "Clubs", "♣", "Black", "Athlete", "Michael Phelps", "Swimming", "a gold medal", "Olympic legend.", "Swimming", "🏊🥇", "The K is a fork. Imagine Phelps swimming for a gold medal. Taste the chlorine."),

    // ♠ SPADES - VILLAINS
    CardEntry("A♠", "Ace", "Spades", "♠", "Black", "Villain", "Cleopatra", "Reigning", "a golden throne", "Egyptian Queen.", "History", "👑🪑", "The A is a peak. Imagine Cleopatra reigning on a golden throne. Smell the incense."),
    CardEntry("2♠", "Two", "Spades", "♠", "Black", "Villain", "Julius Caesar", "Stabbing", "a toga pin", "Roman dictator.", "History", "🗡️👘", "The 2 is a swan. Imagine Caesar being stabbed with a toga pin. See the blood."),
    CardEntry("3♠", "Three", "Spades", "♠", "Black", "Villain", "Napoleon", "Pointing", "a bicorne hat", "French emperor.", "History", "🎩👉", "The 3 is a curve. Imagine Napoleon pointing in a bicorne hat. Feel the chill."),
    CardEntry("4♠", "Four", "Spades", "♠", "Black", "Villain", "Jack the Ripper", "Stabbing", "a bloody knife", "Victorian killer.", "History", "🔪🩸", "The 4 is a flag. Imagine Jack the Ripper stabbing with a bloody knife. Smell the fog."),
    CardEntry("5♠", "Five", "Spades", "♠", "Black", "Villain", "Billy the Kid", "Shooting", "a revolver", "Wild West outlaw.", "History", "🔫🤠", "The 5 is a hook. Imagine Billy the Kid shooting a revolver. Hear the bang."),
    CardEntry("6♠", "Six", "Spades", "♠", "Black", "Villain", "Lucrezia Borgia", "Poisoning", "a wine goblet", "Renaissance noble.", "History", "🍷💀", "The 6 is a loop. Imagine Lucrezia poisoning a wine goblet. Smell the bitter almond."),
    CardEntry("7♠", "Seven", "Spades", "♠", "Black", "Villain", "The Devil", "Tempting", "a burning contract", "The ultimate villain.", "Myth", "😈📜", "The 7 is a bar. Imagine the Devil tempting with a burning contract. Feel the heat."),
    CardEntry("8♠", "Eight", "Spades", "♠", "Black", "Villain", "Ivan the Terrible", "Raging", "a scepter", "Russian Tsar.", "History", "😡🪄", "The 8 is loops. Imagine Ivan raging with a scepter. Hear the thunder."),
    CardEntry("9♠", "Nine", "Spades", "♠", "Black", "Villain", "Vlad the Impaler", "Impaling", "a wooden stake", "Romanian ruler.", "History", "🪵🩸", "The 9 is a tail. Imagine Vlad impaling with a wooden stake. Smell the blood."),
    CardEntry("10♠", "Ten", "Spades", "♠", "Black", "Villain", "Attila the Hun", "Raiding", "a horsewhip", "Hun warrior.", "History", "🏇🐎", "The 10 is a circle. Imagine Attila raiding with a horsewhip. Feel the hooves."),
    CardEntry("J♠", "Jack", "Spades", "♠", "Black", "Villain", "Jesse James", "Robbing", "a train", "Outlaw.", "History", "🚂💰", "The J is a hook. Imagine Jesse James robbing a train. Hear the whistle."),
    CardEntry("Q♠", "Queen", "Spades", "♠", "Black", "Villain", "Queen Mary I", "Burning", "a torch", "Bloody Mary.", "History", "🔥👸", "The Q is a circle. Imagine Mary burning a torch. Feel the heat."),
    CardEntry("K♠", "King", "Spades", "♠", "Black", "Villain", "King Tut", "Ruling", "a golden mask", "Egyptian pharaoh.", "History", "👑🎭", "The K is a fork. Imagine King Tut ruling in a golden mask. See the shine.")
)

fun getCard(card: String): CardEntry? = CARD_DATA.find { it.card == card }
