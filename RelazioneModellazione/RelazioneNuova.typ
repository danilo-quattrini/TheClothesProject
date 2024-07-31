#import "@preview/fletcher:0.5.1" as fletcher: diagram, node, edge
#import "./in-dexter.typ":*

#set page(numbering: "1")

#figure( 
  image("universita-di-camerino-logo.svg", width: 35%),
  numbering: "1.1"
)<UnicamLogo>

#set text(
  lang: "it",     
  font: "Century Schoolbook",
  size: 14pt
)
#set par(
  justify: true,   
)
#align(center, text(20pt)[
  = Sviluppo di un’applicazione Java ontology-based  per la \ configurazione  di un capo \ d’abbigliamento
  
])
#align(center+bottom,text(18pt)[

    \ ST1414 Modellazione e Gestione della Conoscenza

    \ Danilo quattrini

    \ Corso di laurea triennale in \ Informatica per la comunicazione digitale \
Università degli Studi di Camerino
\ Anno Accademico 2023/24

])
#pagebreak()

//Index page for the arguments that i'm going to explane 
#make-index(title: [Indice],outlined: false, use-page-counter: true)

#pagebreak()

#set heading( numbering:"1.11")
#show heading.where(level: 1): set text(20pt)
#show heading.where(level: 2): set text(18pt)

= Overview del progetto
#index[Overview del progetto]
Il mondo della moda è in continua evoluzione e l'adozione di nuove tecnologie gioca un ruolo cruciale in questo cambiamento. Tra le innovazioni più interessanti e utili nel settore vi è il configuratore di vestiti. Questa relazione esamina l'importanza e l'uso del configuratore di vestiti nell'industria della moda, analizzando le sue caratteristiche principali e i benefici che offre.
Il configuratore di vestiti permette a chi lo utilizza di personalizzare i propri capi di abbigliamento in base alle loro preferenze individuali. Questa funzionalità include la selezione del tipo di vestito il tessuto il colore e la taglia che vogliamo attribuirgli.
I vantaggi che possiamo riscontrare nell’utilizzo di tale configuratore, per le aziende che sono competenti in questo ambito sono le seguenti:

#list(
  [*Riduzione dei costi:* automazione e precisione nella produzione risparmiando tempo e spese inutili.], 
  [*Maggiore fedeltà del cliente:* offrire personalizzazione ampia e crea un legame più forte con il brand.], 
  [*Innovazione e competitività: * adottare tecnologie avanzate posiziona l'azienda come leader nel settore.]
)
I clienti che usufruiscono di tale prodotto non son da meno, saranno coloro che ne trarranno più beneficio, questo perché avranno:

#list(
  [*Esperienza di acquisto Personalizzata:* i clienti possono ottenere capi unici e perfettamente adatti alle loro esigenze..], 
  [*Maggiore soddisfazione:* la capacità di visualizzare e modificare i vestiti in tempo reale aumenta la soddisfazione del cliente], 
  [*Contributo alla Sostenibilità: * i consumatori possono fare scelte più ecologiche grazie alla produzione su richiesta..]
)
Si è venuto anche a descrivere i vari eventi sociali, in cui sarebbe opportuno indossare quel determinato capo, importando un’ontologia già presente, chiamatasi
*``` SocietalEvent ```*presente nel sito  dbpedia@Dbpedia ed utilizzata in questo progetto per, riferirmi ad eventi di contesto sociale nella quale una persona deve indossare un particolare indumento invece che un altro.
#pagebreak()
L’ontologia può essere sempre più ampliata per quanto riguarda i diversi tipi di materiale e di colori che sono presenti nel mondo, ma qui troverete quelli più di comune utilizzo, si è create anche una classe per la rappresentazione dei tipi di pattern che potrebbe assumere un dato indumento.\

Qui sarà mostrata ora un view breve di cosa è presente nel file ```rust TheClothesProject.rdf``` con le varie classi che sono state rappresentate per il suo funzionamento.

//Creazione della mappa concettuale
#text(14pt)[
#figure(caption: "Albero rappresentativo dell'ontologia")[
  #diagram(
    edge-stroke: 0.5pt,
    node-stroke: 0.5pt,
    node-corner-radius: 5pt,
    spacing: 10pt,
    node((0,0),[owl:Thing]),
    edge("-"),

    node((0,1)),
    edge("-|>"),
    node((1,1),[cp:Clothes]),
    node((1,1)),
    edge("-"),
      node((1,2)),
      edge("-|>"),
      node((2,2),[cp:Shoes]),
      node((1,3)),
      edge("-|>"),
      node((2,3),[cp:Upper]),


      node((1,4)),
      edge("-|>"),
      node((2,4),[cp:Lower]),
      node((1,1)),
      edge("-"),
      node((1,5)),
      edge("-|>"),
      node((2,5),[cp:Accessory]),

      node((0,1)), 
      edge("-"),
    node((0,6)),
    edge("-|>"),
    node((1,6),[cp:ClothesPattern]),
    node((0,6)),
    edge("-"),
    
    node((0,7)),
    edge("-|>"),
    node((1,7),[cp:ClothesMaterial]),
    node((1,7)),
    edge("-"),
      edge("-"),
      node((1,8)),
      edge("-|>"),
      node((2,8),[cp:NaturalClothesMaterial]),
      node((1,8)),
      edge("-"),
    
      node((1,9)),
      edge("-|>"),
      node((2,9),[cp:SyntheticClothesMaterial]),

      node((0,7)), 
      edge("-"),


    node((0,10)),
    edge("-|>"),
    node((1,10),[cp:Events]),
    node((0,10)),
    edge("-"),
    
    node((0,11)),
    edge("-|>"),
    node((1,11),[cp:Colours]),
    node((0,11)),
    edge("-"),
    
    node((0,12)),
    edge("-|>"),
    node((1,12),[cp:Gender]),
    edge("-"),
      node((1,13)),
      edge("-|>"),
      node((2,13),[cp:Female]),
    
      node((1,12)),
      edge("-"),
    
      node((1,14)),
      edge("-|>"),
      node((2,14),[cp:Male]),

      node((0,12)), 
      edge("-"),

    node((0,15)), 
    edge("-|>"), 
    node((1,15),[cp:Season])
  )
]
]
#pagebreak()
= Ontologia
L'ontologia e l'inferenza sono elementi chiave per garantire il buon funzionamento e l'efficacia di un configuratore di vestiti. L'ontologia fornisce una struttura organizzata delle informazioni, mentre l'inferenza permette di derivare nuove conoscenze e migliorare la personalizzazione. Questa sezione descrive come utilizzare correttamente l'ontologia e l'inferenza per ottimizzare il configuratore di vestiti. Cos’è però l’inferenza in sé per sé?\

L’inferenza sarebbe il processo di fare deduzioni e trarre conclusioni logiche basate su conoscenze o informazioni già esistenti, utilizzando regole, assiomi e relazioni prestabiliti per ricavare nuove informazioni che potrebbero non essere esplicitamente dichiarate o rappresentate nei dati forniti. Rappresentando la conoscenza del dominio in modo formale, le ontologie consentono ai motori di ragionamento automatizzati (reasoner) di trarre conclusioni, fare deduzioni e rispondere a domande complesse sulla base delle informazioni disponibili. 
== Esclusività
Per quanto riguarda l’esclusività, ogni classe nell’ontologia è progettata per avere un suo tipo specifico di funzionamento, evitando così che sottoclassi e individui vengano mescolati tra loro in modo diretto. Questo approccio permette a ciascuna classe di mantenere le proprie caratteristiche uniche e distintive.\

Ad esempio, la classe *``` ClothesMaterial```*  è dedicata a rappresentare i materiali utilizzati per i capi di abbigliamento, come *``` Cotton ```*, *``` Leather ```*, e *``` Polyester ```*. Questi materiali non si confondono con le dimensioni dei capi, gestite dalla classe *``` ClothesSize ```* e dalle sue sottoclassi come *``` AccessorySize ```*, *```LowerSize ```*, *``` ShoeSize ```*, e *``` UpperClothingSize ```*. Ogni classe relativa alle dimensioni ha le proprie proprietà e individui, specifici per il tipo di capo che rappresentano, evitando sovrapposizioni con altre classi.\ 

Similmente, la classe Colour rappresenta i colori dei capi di abbigliamento con le relative proprietà di colore come hasColorHex, e non si mescola con le proprietà di dimensione o di materiale. Questa segregazione permette un’organizzazione chiara e un accesso efficiente ai dati, poiché ogni classe gestisce un aspetto specifico e non si sovrappone con altre.\

Inoltre, le classi Pattern e Season gestiscono rispettivamente i motivi decorativi e le stagioni, con le proprie specificità. Ogni classe interagisce con le altre attraverso relazioni ben definite ma mantiene la propria esclusività funzionale. Questo design garantisce che l'ontologia rimanga coerente e che le informazioni possano essere gestite, interrogate e aggiornate in modo preciso e ordinato.

#pagebreak()
#bibliography("refs.bib")