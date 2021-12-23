class Word  {
    var id:Int = 0
    var word:String = ""
    var translate :String = ""


    constructor()

    constructor(word: String, translate: String) {
        this.word = word
        this.translate = translate

    }

    constructor(id: Int, word: String, translate: String) {
        this.id = id
        this.word = word
        this.translate = translate

    }
}