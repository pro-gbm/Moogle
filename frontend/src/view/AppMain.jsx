import { Fragment } from "react";

function AppMain() {
    console.log('테스트!!!!')
  return (
    <Fragment>
      <div
        style={{
          color: 'white',
          textAlign: 'center',
          paddingTop:'15%',
          fontSize: '80px',
          fontFamily:'serif',
          fontWeight: 'bold'
        }}>Choose Your OTT</div>
      <div 
        style={{
          display:'flex',
          alignItems:'center',
          justifyContent:'center',
          color: 'white',
          padding: '30px',
          fontSize: '30px'
          }}>
        <div 
          style={{
            marginRight:'10px',
            border: '2px solid white',
            borderRadius: '40px',
            textAlign: 'center',
            fontFamily:'serif',
            padding: '20px 60px 20px 60px'
        }}>Drama</div>
        <div 
          style={{
            marginLeft:'10px',
            border: '2px solid white',
            borderRadius: '40px',
            textAlign: 'center',
            fontFamily:'serif',
            padding: '20px 60px 20px 60px'
        }}>Movie</div>
      </div>
    </Fragment>
  )
}

export default AppMain;
