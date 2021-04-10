import {Map, GoogleApiWrapper, Marker, InfoWindow} from 'google-maps-react';

function InteractiveMap(props) {
    const locations = [
        ['Flumserberg', 47.093661111111, 9.2853888888889],
        ['Toggenburg / Wildhaus', 47.2007645115355, 9.34400081634521],
        ['Pizol', 46.978846944253625, 9.435625076293947],
        ['Braunwald', 46.933333333333, 9],
        ['Amden', 47.149334, 9.141827],
        ['Wolzenalp (Krummenau)', 47.22471764120549, 9.196062148437477],
        ['Atzmännig', 47.28613237333799, 8.996961975097747],
        ['Ebenalp', 47.2866588, 9.428590900000017],
        ['Elm', 46.91372199177602, 9.161413574218841],
        ['Schilt / Mollis', 47.07629255301451, 9.095667266845794],
        ['Appenzell (Skilift Sollen)', 47.32519957274132, 9.407597446441676],
        ['Ebnat-Kappel (Skilift Tanzboden)', 47.25115840145275, 9.110473060607935]
    ];

    let state = {
        showingInfoWindow: true,
    };

    const onMarkerClick = () => {
        state.showingInfoWindow = !state.showingInfoWindow;
        console.log('Show/Hide Window');
    }

    const displayMarkers = () => {
        return locations.map((location, index) => {
            return <Marker key={index} id={index} position={{
                //lat: resort.latitude,
                lat: location[1],
                //lng: resort.longitude,
                lng: location[2]
            }} title={location[0]} name={'TESTINGGG'}
               onClick={() => console.log("You clicked me!")}
            />
        })
    }

    return (
        <div>
            {/*<iframe width="600" height="450" loading="lazy" allowFullScreen style={{border: 0}}
                    //src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJO6qI2NYqm0cROCoiU5uZkJo&key=AIzaSyD3d6K7s9hUo-RcxyA9VLn3gag2MeNFi4A"/>
                    src="https://www.google.com/maps/embed/v1/search
                    ?key=AIzaSyD3d6K7s9hUo-RcxyA9VLn3gag2MeNFi4A
                    &q=record+stores+in+Seattle"/>
            */}
            <Map
                google={props.google}
                zoom={10}
                style={{ margin: 20, width: '70%', height: '80%'}}
                initialCenter={{ lat: locations[0][1], lng: locations[0][2]}}
            >
                {displayMarkers()}

            </Map>
        </div>
       );
}

export default GoogleApiWrapper({
    apiKey: 'AIzaSyD3d6K7s9hUo-RcxyA9VLn3gag2MeNFi4A'
})(InteractiveMap)