package com.u.tallerify.networking.interactor.user;

import android.content.Context;
import android.support.annotation.NonNull;
import com.u.tallerify.model.entity.Artist;
import com.u.tallerify.model.entity.Playlist;
import com.u.tallerify.model.entity.Song;
import com.u.tallerify.model.entity.User;
import com.u.tallerify.networking.ReactiveModel;
import com.u.tallerify.networking.RestClient;
import com.u.tallerify.networking.services.user.UserService;
import java.util.List;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by saguilera on 3/19/17.
 */
@SuppressWarnings("unchecked")
public final class UserInteractor {

    public static final int ACTION_LOADING = 0;

    private static final @NonNull UserInteractor instance = new UserInteractor();

    @NonNull BehaviorSubject<ReactiveModel<User>> userSubject;
    @NonNull BehaviorSubject<ReactiveModel<List<Song>>> songSubject;
    @NonNull BehaviorSubject<ReactiveModel<List<Playlist>>> playlistSubject;
    @NonNull BehaviorSubject<ReactiveModel<List<Artist>>> artistSubject;

    private UserInteractor() {
        userSubject = BehaviorSubject.create();
        songSubject = BehaviorSubject.create();
        playlistSubject = BehaviorSubject.create();
        artistSubject = BehaviorSubject.create();
    }

    public static @NonNull UserInteractor instance() {
        return instance;
    }

    @NonNull
    public Observable<ReactiveModel<User>> observeUser() {
        return userSubject;
    }

    @NonNull
    public BehaviorSubject<ReactiveModel<List<Song>>> observeSongs() {
        return songSubject;
    }

    @NonNull
    public BehaviorSubject<ReactiveModel<List<Playlist>>> observePlaylists() {
        return playlistSubject;
    }

    @NonNull
    public BehaviorSubject<ReactiveModel<List<Artist>>> observeArtists() {
        return artistSubject;
    }

    public Observable<User> currentUser(@NonNull Context context) {
        return RestClient.with(context).create(UserService.class)
            .currentUser()
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<User>() {
                @Override
                public void call(final User user) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .model(user)
                        .build());
                }});
    }

    public Observable<User> addSongFavorite(@NonNull Context context, long songId) {
        return RestClient.with(context).create(UserService.class)
            .addSongFavorite(songId)
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<User>() {
                @Override
                public void call(final User user) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .model(user)
                        .build());
                }});
    }

    public Observable<User> addArtistFavorite(@NonNull Context context, long artistId) {
        return RestClient.with(context).create(UserService.class)
            .addArtistFavorite(artistId)
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<User>() {
                @Override
                public void call(final User user) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .model(user)
                        .build());
                }});
    }

    public Observable<User> removeSongFavorite(@NonNull Context context, long songId) {
        return RestClient.with(context).create(UserService.class)
            .removeSongFavorite(songId)
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<User>() {
                @Override
                public void call(final User user) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .model(user)
                        .build());
                }});
    }

    public Observable<User> removeArtistFavorite(@NonNull Context context, long artistId) {
        return RestClient.with(context).create(UserService.class)
            .removeArtistFavorite(artistId)
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<User>() {
                @Override
                public void call(final User user) {
                    userSubject.onNext(new ReactiveModel.Builder<User>()
                        .model(user)
                        .build());
                }});
    }

    public Observable<List<Song>> songs(@NonNull Context context) {
        return RestClient.with(context).create(UserService.class)
            .songs()
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    songSubject.onNext(new ReactiveModel.Builder<List<Song>>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    songSubject.onNext(new ReactiveModel.Builder<List<Song>>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<List<Song>>() {
                @Override
                public void call(final List<Song> songs) {
                    songSubject.onNext(new ReactiveModel.Builder<List<Song>>()
                        .model(songs)
                        .build());
                }});
    }

    public Observable<List<Artist>> artists(@NonNull Context context) {
        return RestClient.with(context).create(UserService.class)
            .artists()
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    artistSubject.onNext(new ReactiveModel.Builder<List<Artist>>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    artistSubject.onNext(new ReactiveModel.Builder<List<Artist>>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<List<Artist>>() {
                @Override
                public void call(final List<Artist> artists) {
                    artistSubject.onNext(new ReactiveModel.Builder<List<Artist>>()
                        .model(artists)
                        .build());
                }});
    }

    public Observable<List<Playlist>> playlists(@NonNull Context context) {
        return RestClient.with(context).create(UserService.class)
            .playlists()
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    playlistSubject.onNext(new ReactiveModel.Builder<Playlist>()
                        .action(ACTION_LOADING)
                        .build());
                }
            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(final Throwable throwable) {
                    playlistSubject.onNext(new ReactiveModel.Builder<Playlist>()
                        .error(throwable)
                        .build());
                }
            }).doOnNext(new Action1<List<Playlist>>() {
                @Override
                public void call(final List<Playlist> playlists) {
                    playlistSubject.onNext(new ReactiveModel.Builder<List<Playlist>>()
                        .model(playlists)
                        .build());
                }});
    }

}
