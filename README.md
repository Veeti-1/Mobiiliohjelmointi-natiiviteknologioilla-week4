# Mobiiliohjelmointi-natiiviteknologioilla-week4
## Mitä tehtiin
  - tehtävä 4 tehtiin tehtävään 3(https://github.com/Veeti-1/-Mobiiliohjelmointi-natiiviteknologioilla-week3) jatkona
  - Sovellukseen lisättiin kalenteri- ja asetuksetnäkymä
  - Kalenteri-,lista- ja asetusnäkymän vaihtoa hallittiin navhost ja navcontrollerilla
### Mitä tarkoittaa navigointi Jetpack Composessa?
  - Navigointi Jetpack Composessa on deklaratiivinen järjestelmä, jolla voidaan hallita sovelluksen siirtymistä eri composable funktioiden välillä.
### Mitä ovat NavHost ja NavController?
  - Navhost on säiliö, joka näyttää aktiivisen näytön. NavHost yhdistää NavControllerin navigointikaavioon.
  - NavController seuraa sovelluksen tilaa, sillä suoritetaan siirtymät.
### Miten sovelluksesi navigaatiorakenne on toteutettu (Home ↔ Calendar)?
  - navController -> rememberNavController luo navControllerin, joka vastaa sovelluksen navigoinnista
  - NavHost -> määrittelee aloitus näkymän (tartDestination = HOME_ROUTE)
  - HomeScreen saa callbackin (onNavigateCalendar)
  - Käyttäjä painaa kalenteri nappia -> siirrytään kalenteriin
  - Kalenterissa, kun painetaan listanappia -> siirrytään takaisin listaan(onNavigateHome)
  - HomeScreenissa voidaan myös siirtyä "asetukset" sivulle -> (onNavigateSettings) ja asetuksista takaisin listanäkymään(onNavigateHome)
### Miten MVVM ja navigointi yhdistyvät (yksi ViewModel kahdelle screenille)?
  - viewModel määritellään mainaktivityssä: ( `` val viewModel: TaskViewModel = viewModel() `` ) ja annetaan parametrinä( ``  composable(HOME_ROUTE) {
                    viewModelHomeScreen(
                        viewModel= viewModel, `` ) 
### Miten ViewModelin tila jaetaan kummankin ruudun välillä?
  - Viewmodel määritellään mainaktivityssä ja annetaan parametrinä funktioille
### Miten CalendarScreen on toteutettu (miten tehtävät ryhmitellään / esitetään kalenterimaisesti)?
  - omalle riville annetaan "otsikkona" päivämäärä, jonka alla on sen päivän taskit
### Miten AlertDialog hoitaa addTask ja editTask?
  - Lista näkymässä voidaan painaa "Add" nappia, joka avaa Alertdialogin, jossa voidaan lisätä Title, Description ja Duedate, ja lisäämällä listaan painamalla save.
  - Lista- ja kalenterinäkymässä voidaan avata taskin muokkaus Alertdialog, jossa voidaan muokata titleä ja descriptionia tai poistaa taski.

#### APK löytyy release:sta
#### Youtube-demo : https://youtu.be/M43XIBuaMMU
