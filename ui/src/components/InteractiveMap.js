import { Map, GoogleApiWrapper, Marker } from "google-maps-react";
import { useEffect } from "react";
import { googleMapsApiKey } from "../config";

function InteractiveMap(props) {
  useEffect(() => {
    console.log("Center map on lat=" + props.lat + " long=" + props.long);
  }, [props.lat, props.long]);
  let state = {
    showingInfoWindow: true,
  };

  const onMarkerClick = () => {
    state.showingInfoWindow = !state.showingInfoWindow;
    console.log("Show/Hide Window");
  };

  const displayMarkers = () => {
    return props.resorts.map((resort, index) => {
      return (
        <Marker
          key={index}
          id={resort.id}
          position={{
            lat: resort.location.latitude,

            lng: resort.location.longitude,
          }}
          title={resort.name}
          name={"TESTINGGG"}
          onClick={() => onMarkerClick()}
        />
      );
    });
  };

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
        center={{ lat: props.lat, lng: props.long}}
    >
        {displayMarkers()}

    </Map>
</div>
  );
}

export default GoogleApiWrapper({
  apiKey: googleMapsApiKey,
})(InteractiveMap);
