import { useNavigate } from "react-router-dom";

const AppMain = () => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate("/survey");
  };
  return (
    <>
      <div
        style={{
          color: "white",
          textAlign: "center",
          paddingTop: "15%",
          fontSize: "80px",
          fontFamily: "serif",
          fontWeight: "bold",
        }}
      >
        Choose Your OTT
      </div>
      <div
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          color: "white",
          padding: "30px",
          fontSize: "30px",
        }}
      >
        <button
          type="button"
          style={{
            display: "inline-block",
            marginRight: "10px",
            border: "2px solid white",
            borderRadius: "40px",
            textAlign: "center",
            fontFamily: "serif",
            padding: "20px 60px 20px 60px",
            cursor: "pointer",
          }}
          onClick={handleClick}
        >
          Drama
        </button>
        <button
          type="button"
          style={{
            marginLeft: "10px",
            border: "2px solid white",
            borderRadius: "40px",
            textAlign: "center",
            fontFamily: "serif",
            padding: "20px 60px 20px 60px",
            cursor: "pointer",
          }}
        >
          Movie
        </button>
      </div>
    </>
  );
};

export default AppMain;
