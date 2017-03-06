/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

/**
 *
 * @author Valannos
 */
public enum Serie {

    HABITABLE,
    QUILLARD;

    public static char getSerie(Serie serie) {

        switch (serie) {

            case HABITABLE:
                return 'H';

            case QUILLARD:
                return 'Q';

            default:
                return 0;

        }

    }
}
