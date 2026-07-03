{
  description = "Java development";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  };

  outputs =
    { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = with pkgs; [
          jdk25
          maven
          gradle
          git
          gdb
        ];

        shellHook = ''
          export JAVA_HOME=${pkgs.jdk21}
          export PATH=$JAVA_HOME/bin:$PATH
          java -version
        '';
      };
    };
}
