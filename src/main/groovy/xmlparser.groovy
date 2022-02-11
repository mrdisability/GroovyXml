def xmlFile = getClass().getResourceAsStream("articles.xml")

def articles = new XmlParser().parse(xmlFile)

//Add article
def articleNode = new NodeBuilder().article(id: '5') {
    title('Traversing XML in the nutshell')
    author {
        firstname('Martin')
        lastname('Schmidt')
    }
    'release-date'('2019-05-18')
}
articles.append(articleNode)

//Modifying article
articles.article.each { it.'release-date'[0].value = "2019-05-18" }

println articles.article.findAll { it.'release-date'.text() != "2019-05-18" }.isEmpty()

//Replace article
def secondArticleNode = new NodeBuilder().article(id: '5') {
    title('Traversing XML in the nutshell')
    author {
        firstname('Martin')
        lastname('Schmidt')
    }
    'release-date'('2019-05-18')
}
articles.article[0].replaceNode(secondArticleNode)

//println articles

//Remove article
articles.article
.findAll { it.author.'@id'.text() != "3" }
.each { articles.remove(it) }
