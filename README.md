# Tallerify

Tallerify is a "Spotify" Android client, for academic uses (its a work for the subject "Taller 2" in Facultad de Ingenieria UBA).

[![Coverage Status](https://coveralls.io/repos/github/saantiaguilera/fiuba-taller-II-tallerify-android/badge.svg?branch=develop)](https://coveralls.io/github/saantiaguilera/fiuba-taller-II-tallerify-android?branch=develop)

[![Build Status](https://travis-ci.org/saantiaguilera/fiuba-taller-II-tallerify-android.svg?branch=develop)](https://travis-ci.org/saantiaguilera/fiuba-taller-II-tallerify-android)

## Honour the JVM

How to dance correctly:

1. Swing left  : 〜(￣▽￣〜)

2. Swing right : (〜￣▽￣)〜

3. Repeat until song finishes.

## Example

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

〜(￣▽￣〜)

(〜￣▽￣)〜

## Cambios talves necesarios

1. No hay endpoints para los trendings artists / songs (artists/trending y songs/trending ?)
2. No hay endpoints para las playlists de un user (me/playlists ?)
3. No hay endpoints para "seguir" o tener contactos entre usuarios (users/{id}/follow POST/DELETE ?)
4. `AlbumShort` que conserve el campo de `images`, sino la song no tengo con que imagen mostrarla. (y no voy a hacer n*endpoints para averiguar todas)
Mismo con `ArtistShort` y con `Playlist` vamos a tener que agregar un campo `images` (que use las imagenes del album asociado a la primer cancion?). Todas por la misma razon.
5. No hay endpoints para search (search/artists?query="asdf" || search/songs?query="asdf" || search/albums?query="asdf" ?)