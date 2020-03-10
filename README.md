# Icefield
Szoftver Projekt Laboratórium projektmunka

A játékban a különböző képességű szereplőknek (3 vagy több játékos lehet) kell egy tengerrel körülvett jégmezőn túlélniük.
A szereplők lehetnek eszkimók vagy sarkkutatók, és körökre osztva tevékenykednek. A jégmező jégtáblákból áll. Vannak stabil jégtáblák,
amelyeken akárhány szereplő állhat, és vannak instabil jégtáblák, amik adott létszám felett átfordulnak és ilyenkor a rajtuk állók a
vízbe esnek. Jégtábla átfordulásnál az adott jégtáblán lévő hóréteg eltűnik, ha esetleg tárgy volt a jégtáblában, az továbbra is benne
marad és kiásható. A vízbe esett szereplők vagy köteles szomszédjuk által menthetők meg, vagy ha búvár ruhában vannak.  A köteles kimentés
és a búvár ruhával kimászás a vízből egy munkaegység. Kötéllel egy munkaegység ráfordításával egy szereplő menthető meg. A kimentett
szereplő arra a jégtáblára kerül, amelyiken az őt kimentő szereplő tartózkodik. Ha egy szereplő egy instabil jégtáblára lépett,
és a jégtábla átfordult, minden a jégtábláról vízbe esett szereplő kimenthető kötéllel addig, amíg a játékban ismét a jégtábla
átfordulását okozó játékos lépése következne. Addig, ha olyan játékos lépése következne, aki éppen a vízben van és nincsen búvárruhája,
azt úgy kezeljük, mintha kimaradt volna. A jégtáblákat a játék kezdetén eltérő mennyiségű hó borítja. A jégtáblákon a játékosok számának
függvényében van maximalizálva a hóréteg vastagsága. Az egyes jégtáblákba különféle tárgyak lehetnek belefagyva: lapát, kötél, búvárruha,
élelem, pisztoly, jelzőfény, patron stb. Egy szereplő annyi tárgyat hordhat magával, amennyit szeretne. Élelem kivételével az összes tárgy
többször használatos. Egy jégtáblában maximum egy tárgy lehet. Befagyott tárgyat csak akkor lehet meglátni és kiásni, ha a jégtábla tiszta,
nem borítja hó és ekkor látszik, hogy milyen tárgy van a jégtáblában. A jégtáblák között lehetnek hóval fedett lyukak is, amibe beleesve
csak a búvárruhát viselők élnek túl, vagy azok, akiket egy köteles barátjuk bármely szomszédos jégtábláról azonnal kimenekít. 
Minden szereplő egy körben 4 egységnyi munkát végezhet. Ilyen munka például a jégtáblán lévő egységnyi mennyiségű hó eltakarítása,
egy szomszédos jégtáblára való lépés vagy egy kiásott tárgy felvétele. Egy tárgy kiásása kézzel történhet, mely szintén egy munkaegység.
Havat takarítani csak azon a jégtáblán lehet amin áll a szereplő. A lapáttal két egységnyi hó takarítható el egy munka ráfordítással.
A tevékenységek bármilyen sorrendben végezhetők. A jégmezőn időnként feltámad a hóvihar, a vihar befedhet lyukat és néhány érintett
jégtáblát is friss hóval borít be. Egy hóvihar az érintett jégtáblák hórétegét eggyel növeli. Akit elkap vagyis az érintett jégtáblán
tartózkodik, annak a testhője egységnyivel csökken. Az eszkimóknak a játék elején 5 egység testhője van, a sarkkutatónak csak 4.
Egy élelem eggyel növeli a testhőt. Az eredetileg kapott hőegységnél nem lehet több hőegysége egy szereplőnek.
A szereplők jégtábláról-jégtáblára haladnak képességeiknek megfelelően. A sarkkutató meg tudja nézni, hogy az a jégtábla, amire lépne,
hány embert bír el (a luk egyet sem). Az eszkimó tud iglut építeni, amiben átvészelhetők a hóviharok. Az iglu egy jégtábla helyet foglal.
Az igluban bárhány szereplő elfér. Az átvészelt hóvihar után az iglu eltűnik. Egy-egy képesség alkalmazása is egy-egy munkát jelent.
A játék célja egy jelzőrakéta alkatrészeinek (pisztoly, jelzőfény, patron) megtalálása. Az alkatrészek is a jégbe vannak fagyva.
Ha ezeket a csapat összegyűjti és ugyanarra a jégtáblára viszi, akkor egy munka felhasználásával összeszerelhetik és elsüthetik,
amivel megnyerik a játékot. Ehhez azonban mindannyiuknak ugyanott kell állniuk. Ha valaki menet közben meghal
(vízbe esve megfullad vagy elfogy a testhője és kihűl), akkor a játék véget ér.
