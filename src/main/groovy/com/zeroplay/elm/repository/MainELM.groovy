package com.zeroplay.elm.repository

/**
 * Created by kirankumarbs on 11/3/2016.
 */
class MainELM {
    def getTemplate(){
        "module Main exposing (..)\n" +
                "\n" +
                "import Html exposing (..)\n" +
                "import Html.Events exposing (..)\n" +
                "import Html.Attributes exposing (..)\n" +
                "import Html.App as App\n" +
                "\n" +
                "--MODEL\n" +
                "type alias Model\n" +
                "    {message : String}\n" +
                "\n" +
                "--MSG\n" +
                "type Msg =\n" +
                "    Click\n" +
                "    | NoOp\n" +
                "\n" +
                "--INIT\n" +
                "initialModel : (Model, Cmd Msg)\n" +
                "initialModel =\n" +
                "    {message = \"Welcome To ELM Basic Application\"} ! []\n" +
                "\n" +
                "--UPDATE\n" +
                "update : Msg -> Model -> (Model, Cmd Msg)\n" +
                "update msg model =\n" +
                "    case msg of\n" +
                "        Click ->\n" +
                "            model ! []\n" +
                "\n" +
                "--VIEW\n" +
                "view : Model -> Html Msg\n" +
                "view model =\n" +
                "    div []\n" +
                "        [ button [onClick Click] [text \"Click Elm\"]\n" +
                "          span [] [text model.message]\n" +
                "        ]\n" +
                "\n" +
                "--MAIN\n" +
                "main : Program Never\n" +
                "main =\n" +
                "    { init      = initialModel\n" +
                "      update    = update\n" +
                "      view      = view\n" +
                "      subscriptions = subscriptions\n" +
                "     }\n" +
                "\n" +
                "--SUBSCRIPTIONS\n" +
                "subscriptions : Model -> (Sub Msg)\n" +
                "subscriptions model =\n" +
                "    Sub.none\n" +
                "\n" +
                ""
    }
}
