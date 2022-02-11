def xmlFile = getClass().getResourceAsStream("articles.xml")

def articles = new XmlSlurper().parse(xmlFile)

//Read articles
articles.'*'.size() == 4
articles.article[0].author.firstname == "Siena"
articles.article[2].'release-date' == "2018-06-12"
articles.article[3].title == "Java 12 insights"
articles.article.find { it.author.'@id' == "3" }.author.firstname == "Daniele"

//Add article
articles.appendNode {
    article(id: '5') {
        title('Traversing XML in the nutshell')
        author {
            firstname('Martin')
            lastname('Schmidt')
        }
        'release-date'('2019-05-18')
    }
}

//Modify article
articles.article.each { it.'release-date' = "2019-05-18" }

//Replace article
articles.article[0].replaceNode {
    article(id: '5') {
        title('Traversing XML in the nutshell')
        author {
            firstname('Martin')
            lastname('Schmidt')
        }
        'release-date'('2019-05-18')
    }
}

//Remove article
articles.article
        .findAll { it.author.'@id' != "3" }
        .replaceNode {}



