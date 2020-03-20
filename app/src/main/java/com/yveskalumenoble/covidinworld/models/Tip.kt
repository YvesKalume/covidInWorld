package com.yveskalumenoble.covidinworld.models

data class Tip(var text : String)

object Supplier {
    val tip = listOf<Tip>(
        Tip("Se laver les mains avec une solution hydroalcoolique ou à l’eau et au savon tue le virus s’il est présent sur vos mains."),
        Tip("Maintenir une distance d’au moins 1 mètre avec les autres personnes, en particulier si elles toussent, éternuent ou ont de la fièvre."),
        Tip("Les mains sont en contact avec de nombreuses surfaces qui peuvent être contaminées par le virus. Si vous vous touchez les yeux, le nez ou la bouche, vous risquez d’être en contact avec le virus présent sur ces surfaces."),
        Tip("Se couvrir la bouche et le nez avec le pli du coude ou avec un mouchoir en cas de toux ou d’éternuement – jeter le mouchoir immédiatement après dans une poubelle fermée et se laver les mains avec une solution hydroalcoolique ou à l’eau et au savon."),
        Tip("Si vous commencez à vous sentir mal, même si vous n’avez que des symptômes bénins comme des maux de tête et un faible écoulement nasal, restez chez vous jusqu’à la guérison."),
        Tip("En cas de fièvre, de toux et de difficultés respiratoires, consultez un médecin sans tarder, car il peut s’agir d’une infection respiratoire ou d’une autre affection grave. Appelez votre médecin et indiquez-lui si vous avez récemment voyagé ou été en contact avec des voyageurs."),
        Tip("Pour retirer le masque: l’enlever par derrière (ne pas toucher le devant du masque); le jeter immédiatement dans une poubelle fermée; se laver les mains avec une solution hydroalcoolique ou à l’eau et au savon."),
        Tip("Le masque n’est efficace que s’il est associé à un lavage des mains fréquent avec une solution hydroalcoolique ou à l’eau et au savon")
    )

    fun next(index: Int) : String {
        return this.tip[index].text

    }
    val link ="https://www.who.int/fr/emergencies/diseases/novel-coronavirus-2019/advice-for-public"
}