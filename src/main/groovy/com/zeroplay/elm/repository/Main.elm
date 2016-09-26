module Main exposing (..)

import Html exposing (..)
import Html.Events exposing (..)
import Html.Attributes exposing (..)
import Html.App as App

--MODEL
type alias Model
    {message : String}

--MSG
type Msg =
    Click
    | NoOp

--INIT
initialModel : (Model, Cmd Msg)
initialModel =
    {message = "Welcome To ELM Basic Application"} ! []

--UPDATE
update : Msg -> Model -> (Model, Cmd Msg)
update msg model =
    case msg of
        Click ->
            model ! []

--VIEW
view : Model -> Html Msg
view model =
    div []
        [ button [onClick Click] [text "Click Elm"]
          span [] [text model.message]
        ]

--MAIN
main : Program Never
main =
    { init      = initialModel
      update    = update
      view      = view
      subscriptions = subscriptions
     }

--SUBSCRIPTIONS
subscriptions : Model -> (Sub Msg)
subscriptions model =
    Sub.none


