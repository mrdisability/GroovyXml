import groovy.xml.MarkupBuilder

def writer = new StringWriter()
new MarkupBuilder(writer).articles {
    article {
        title('First steps in Java')
        author(id: '1') {
            firstname('Siena')
            lastname('Kerr')
        }
        'release-date'('2018-12-01')
    }
    article {
        title('Dockerize your SpringBoot application')
        author(id: '2') {
            firstname('Jonas')
            lastname('Lugo')
        }
        'release-date'('2018-12-01')
    }
}

println writer.toString()
