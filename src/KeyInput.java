import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyInput extends MouseAdapter {

    //Referenzen
    private Game game;
    private Kniffel kniffel;
    private Regeln regeln;
    private Namen namen;


    public KeyInput(Game game, Kniffel kniffel, Regeln regeln, Namen namen) {

        this.game = game;
        this.kniffel = kniffel;
        this.regeln = regeln;
        this.namen = namen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getX());
        System.out.println(e.getY());

        //MENU MouseEvent
        if (game.gamestate == State.Menu) {

            //New Game Button
            if (e.getX() > 450 && e.getX() < 750) {
                if (e.getY() > 150 && e.getY() < 250) {
                    if(namen.isopen == false) {
                        game.gamestate = State.Kniffel;
                    }
                }
            }

            //Regeln Button
            if (e.getX() > 450 && e.getX() < 750) {
                if (e.getY() > 350 && e.getY() < 450) {
                    game.gamestate = State.Regeln;
                }
            }

            //Statistik Button
            if (e.getX() > 450 && e.getX() < 750) {
                if (e.getY() > 550 && e.getY() < 650) {
                    game.gamestate = State.Statistik;
                }
            }

            //Exit Button
            if (e.getX() > 450 && e.getX() < 750) {
                if (e.getY() > 750 && e.getY() < 850) {
                    System.exit(1);
                }
            }
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //REGELN MouseEvent
        if (game.gamestate == State.Regeln) {

            //Back Button
            if (e.getX() > Game.width / 2 - 400 && e.getX() < Game.width / 2 - 100) {
                if (e.getY() > Game.height / 2 + 200 && e.getY() < Game.height / 2 + 280) {
                    game.gamestate = State.Menu;
                }
            }

            //Regeln Seite wechseln
            if (e.getX() > Game.width / 2 + 100 && e.getX() < Game.width / 2 + 400) {
                if (e.getY() > Game.height / 2 + 200 && e.getY() < Game.height / 2 + 280) {
                    if(regeln.givestate() == 1){
                        regeln.setstate(2);

                    }
                    else if(regeln.givestate()==2) {
                        regeln.setstate(1);
                    }
                }
            }
        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //STATISTIK MouseEvent
            if (game.gamestate == State.Statistik) {

                //Back Button
                if (e.getX() > 450 && e.getX() < 750) {
                    if (e.getY() > 795 && e.getY() < 875) {
                        game.gamestate = State.Menu;
                    }
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //WinScreen MouseEvent
        if(game.gamestate == State.WinScreen) {

            //Back Button
            if (e.getX() > 450 && e.getX() < 750) {
                if (e.getY() > 750 && e.getY() < 830) {
                    game.gamestate = State.Menu;
                    namen.NeuOeffnen();
                    namen.isopen = true;
                    kniffel.neuesSpiel();
                }
            }
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            //KNIFFEL MouseEvent
            if (game.gamestate == State.Kniffel) {

                //Neu-Würfeln Button
                if (e.getX() > 50 && e.getX() < 350) {
                    if (e.getY() > 50 && e.getY() < 130) {
                        if (kniffel.würfelCheck[0] == false && kniffel.würfelCheck[1] == false && kniffel.würfelCheck[2] == false && kniffel.würfelCheck[3] == false && kniffel.würfelCheck[4] == false) {
                            //Nichts, da alle Checkboxen auf Nein stehen
                            System.out.println("Debug, alle Checkboxen sind auf NEIN.");
                        } else {
                            //Mindestens 1 Checkbox auf Ja
                            if(kniffel.würfelcount < 3) {
                                //Würfelcount weniger als 3
                                kniffel.neuWürfeln();
                            }
                        }
                    }
                }

                //Auswerten Button
                if (e.getX() > 50 && e.getX() < 350) {
                    if (e.getY() > 800 && e.getY() < 880) {
                        kniffel.Auswerten();
                    }
                }

                //Check Box 1
                if (e.getX() > 180 && e.getX() < 220) {
                    if (e.getY() > 200 && e.getY() < 240) {
                        if (kniffel.würfelCheck[0] == true) {
                            if (kniffel.würfel[0] != 0) {
                                kniffel.würfelCheck[0] = false;
                            }
                        } else {
                            kniffel.würfelCheck[0] = true;
                        }
                    }
                }

                //Check Box 2
                if (e.getX() > 180 && e.getX() < 220) {
                    if (e.getY() > 300 && e.getY() < 340) {
                        if (kniffel.würfelCheck[1] == true) {
                            if (kniffel.würfel[0] != 0) {
                                kniffel.würfelCheck[1] = false;
                            }
                        } else {
                            kniffel.würfelCheck[1] = true;
                        }
                    }
                }

                //Check Box 3
                if (e.getX() > 180 && e.getX() < 220) {
                    if (e.getY() > 400 && e.getY() < 440) {
                        if (kniffel.würfelCheck[2] == true) {
                            if (kniffel.würfel[0] != 0) {
                                kniffel.würfelCheck[2] = false;
                            }
                        } else {
                            kniffel.würfelCheck[2] = true;
                        }
                    }
                }

                //Check Box 4
                if (e.getX() > 180 && e.getX() < 220) {
                    if (e.getY() > 500 && e.getY() < 540) {
                        if (kniffel.würfelCheck[3] == true) {
                            if (kniffel.würfel[0] != 0) {
                                kniffel.würfelCheck[3] = false;
                            }
                        } else {
                            kniffel.würfelCheck[3] = true;
                        }
                    }
                }

                //Check Box 5
                if (e.getX() > 180 && e.getX() < 220) {
                    if (e.getY() > 600 && e.getY() < 640) {
                        if (kniffel.würfelCheck[4] == true) {
                            if (kniffel.würfel[0] != 0) {
                                kniffel.würfelCheck[4] = false;
                            }
                        } else {
                            kniffel.würfelCheck[4] = true;
                        }
                    }
                }

                //Wenn Spieler 1 am Zug
                if (kniffel.SpielerAmZug == 1) {
                    //Kategorie EinsNurEiner
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 160 && e.getY() < 210) {
                            if (kniffel.schonEingetragen[0] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(1);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[0] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsNurZweier
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 210 && e.getY() < 260) {
                            if (kniffel.schonEingetragen[1] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(2);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[1] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsNurDreier
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 260 && e.getY() < 310) {
                            if (kniffel.schonEingetragen[2] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(3);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[2] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsNurVierer
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 310 && e.getY() < 360) {
                            if (kniffel.schonEingetragen[3] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(4);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[3] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsNurFünfer
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 360 && e.getY() < 410) {
                            if (kniffel.schonEingetragen[4] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(5);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[4] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsNurSechser
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 410 && e.getY() < 460) {
                            if (kniffel.schonEingetragen[5] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(6);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[5] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsDreierPasch
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 460 && e.getY() < 510) {
                            if (kniffel.schonEingetragen[6] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(7);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[6] = true;
                                }
                            }
                        }
                    }


                    //Kategorie EinsViererPasch
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 510 && e.getY() < 560) {
                            if (kniffel.schonEingetragen[7] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(8);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[7] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsFullHouse
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 560 && e.getY() < 610) {
                            if (kniffel.schonEingetragen[8] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(9);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[8] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsKleineStraße
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 610 && e.getY() < 660) {
                            if (kniffel.schonEingetragen[9] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(10);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[9] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsGroßeStraße
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 660 && e.getY() < 710) {
                            if (kniffel.schonEingetragen[10] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(11);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[10] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsKniffel
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 710 && e.getY() < 760) {
                            if (kniffel.schonEingetragen[11] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(12);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[11] = true;
                                }
                            }
                        }
                    }

                    //Kategorie EinsChance
                    if (e.getX() > 800 && e.getX() < 950) {
                        if (e.getY() > 760 && e.getY() < 810) {
                            if (kniffel.schonEingetragen[12] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.EinsWürfelEintragen(13);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[12] = true;
                                }
                            }
                        }
                    }
                } else { //Wenn Spieler 2 am Zug
                    //Kategorie ZweiNurEiner
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 160 && e.getY() < 210) {
                            if (kniffel.schonEingetragen[13] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(1);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[13] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiNurZweier
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 210 && e.getY() < 260) {
                            if (kniffel.schonEingetragen[14] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(2);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[14] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiNurDreier
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 260 && e.getY() < 310) {
                            if (kniffel.schonEingetragen[15] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(3);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[15] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiNurVierer
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 310 && e.getY() < 360) {
                            if (kniffel.schonEingetragen[16] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(4);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[16] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiNurFünfer
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 360 && e.getY() < 410) {
                            if (kniffel.schonEingetragen[17] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(5);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[17] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiNurSechser
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 410 && e.getY() < 460) {
                            if (kniffel.schonEingetragen[18] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(6);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[18] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiDreierPasch
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 460 && e.getY() < 510) {
                            if (kniffel.schonEingetragen[19] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(7);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[19] = true;
                                }
                            }
                        }
                    }


                    //Kategorie ZweiViererPasch
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 510 && e.getY() < 560) {
                            if (kniffel.schonEingetragen[20] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(8);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[20] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiFullHouse
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 560 && e.getY() < 610) {
                            if (kniffel.schonEingetragen[21] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(9);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[21] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiKleineStraße
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 610 && e.getY() < 660) {
                            if (kniffel.schonEingetragen[22] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(10);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[22] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiGroßeStraße
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 660 && e.getY() < 710) {
                            if (kniffel.schonEingetragen[23] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(11);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[23] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiKniffel
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 710 && e.getY() < 760) {
                            if (kniffel.schonEingetragen[24] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(12);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[24] = true;
                                }
                            }
                        }
                    }

                    //Kategorie ZweiChance
                    if (e.getX() > 950 && e.getX() < 1100) {
                        if (e.getY() > 760 && e.getY() < 810) {
                            if (kniffel.schonEingetragen[25] == false) {
                                //Check, sodass der Spieler keinen Ungültigen Wurf einträgt
                                if (kniffel.würfel[0] != 0) {
                                    kniffel.ZweiWürfelEintragen(13);
                                    kniffel.NächsterSpieler();
                                    kniffel.WürfelZurücksetzen();
                                    kniffel.schonEingetragen[25] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

