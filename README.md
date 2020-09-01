# ProgettoPOO

## Obiettivo 

Implementare su tutto il progetto DiaDia la libreria Project Lombok documentando tutti gli step di refactoring

## Project Lombok 
Project Lombok  è una popolare libreria open-source Java che aiuta a ridurre la quantità di codice utilizzando annotazioni
[Project Lombok](https://projectlombok.org/)

## Classi modificate

- Labirinto : Getter , Setter , Builder con LabirintoBuilder 
- CaricatoreLabirinto : Getter su istanza Labirinto e Builder su costruttore
- ConfigurazioniIniziali : Builder con ConfigurazioniInizialiBuilder senza istanze, con prop modificato 
- Stanza : Getter e Setter,RequiredArgs e Builder su Costruttore 
- Varie stanze ( Bloccata, Buia, Magica, Protected, MagicaProtected) non modificate
- Attrezzo : Costruttore AllArgs ed annotazione EqualsAndHashCoder ,Getter e Setter 
- AbstractComando : Getter ,Setter (commento secondario )
- Comandi ( tutti ) non modificati
- Borsa : builder,builder.default , getter 
- Giocatore : Getter, Setter, NoArgsConstructor
- AbstractPersonaggio : Getter, RequiredArgsConstructor (commento secondario )
- Cane,Mago,Strega nessuna modifica


Una documentazione con analisi approfondita delle modifiche apportate al progetto è disponibile nel file pdf [Lombok POO](https://github.com/rvg07/ProgettoPOO/blob/master/Lombok%20POO.pdf)


Progetto realizzato da James Ravago & Eduard Ursu
